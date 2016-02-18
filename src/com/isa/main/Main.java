/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.main;

import com.isa.common.ActualCertInfo;
import com.isa.common.FrontCommon;
import com.isa.common.ICommon;
import com.isa.common.ManejadorPaneles;
import com.isa.exception.AppletException;
import com.isa.firma.pades.FirmaPDFController;
import com.isa.firma.pades.PDFFirma;
import com.isa.firma.xades.FirmaXMLController;
import com.isa.front.ListaCertsJPanel;
import com.isa.front.LoginJPanel;
import com.isa.front.MensajeJPanel;
import com.isa.front.ProcesandoJPanel;
import com.isa.plataform.KeyStoreValidator;
import com.isa.security.ISCertSecurityManager;
import com.isa.token.HandlerToken;
import com.isa.utiles.Utiles;
import com.isa.utiles.UtilesMsg;
import com.isa.utiles.UtilesResources;
import com.isa.utiles.UtilesWS;
import com.isa.wsclient.Documento;
import com.isa.wsclient.WSFirmaDocWsException_Exception;
import com.isa.wscv.ValidarDocWSTXException_Exception;
import com.isa.wscv.VerifyResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import netscape.javascript.JSObject;

/**
 *
 * @author JMiraballes
 */
public class Main extends javax.swing.JApplet implements ICommon{

    private JPanel cards;
    /**
     * Initializes the applet Main
     */
    @Override
    public void init() {
        try{
            SecurityManager sm = new ISCertSecurityManager();
            System.setSecurityManager( sm );            
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            initComponents();
            setFrontPanelSize();
            setPanels();
            KeyStoreValidator.setInitStoreValidator(); 
            UtilesResources.setRutaProperties(getParameter("ruta"));
            sincronizarTokens();
            ManejadorPaneles.showPanel(LoginJPanel.class.getName());
        }
        catch( AppletException e ){
            //llamar a mensaje.
            ManejadorPaneles.showPanelMessageError( e.getMsj() );
        }
        
    }
    
    public boolean isValidar(){
        
        if ( getParameter("validar") == null ){
            return true;
        }
        else return Utiles.TRUE_VALUE.equals(getParameter("validar") );
    }
    
    private void sincronizarTokens() throws AppletException {

        HandlerToken handler = new HandlerToken();
        ActualCertInfo.getInstance().setHandler(handler);

        if (handler.isTokenActivo()){
            KeyStoreValidator.setKeystore(KeyStoreValidator.KEYSTORE_TOKEN);
        }
    }   
    
    
    public void firmarDocumento( final String[] params ){ 
       
        System.out.println("Metodo firmarDocumento.");
        for (String str : params){
            System.out.println("Params: " + str);
        }
        String nombreDoc = params[1];
        
        ActualCertInfo actualCertInfo = ActualCertInfo.getInstance();
        if (actualCertInfo.getCertIndex() == -1){
            ManejadorPaneles.showMessageCertList( UtilesMsg.ERROR_CERT_NO_SELECCIONADO );
            return;            
        }
        
        Thread thread = new Thread(){
            @Override
            public void run(){
                try{
                    
                    int tipo = Utiles.getNumeroTipoFirma( params[0] );
                    if (tipo == -1){
                        ManejadorPaneles.showPanelMessageError( UtilesMsg.ERROR_OBTENIENDO_TIPO_DE_FIRMA );
                        firmaError( UtilesMsg.ERROR_OBTENIENDO_TIPO_DE_FIRMA );
                        return;
                    }
                    
                    Documento dElectronico = null;
                            
                    //firma pdf
                    if (tipo == 1){
                        FirmaPDFController firmapdfcontroller = FirmaPDFController.getInstance();
                        dElectronico = UtilesWS.getInstancePortWS().obtenerDocumentoParaFirmar( Arrays.asList(params) );
                        PDFFirma infoFirma = firmapdfcontroller.generarApariencia();
                        byte[] pdf = dElectronico.getDocumento().getValue();

                        InputStream is = new ByteArrayInputStream(pdf);
                        ByteArrayOutputStream pdfOS = firmapdfcontroller.firmar(infoFirma, is);
                        ManejadorPaneles.showPanelMessageInfo( UtilesMsg.DOC_FIRMADO_OK );
                        dElectronico.getDocumento().setValue( pdfOS.toByteArray() );                        
                    }
                    
                    if (tipo == 2){
                        //firma xml 
                        FirmaXMLController firmaxmlcontroller = FirmaXMLController.getInstance();
                        dElectronico = UtilesWS.getInstancePortWS().obtenerDocumentoParaFirmar( Arrays.asList(params) );
                        byte[] xml  = dElectronico.getDocumento().getValue();
                        String strXML = new String(xml);
                        String xmlFirmado = firmaxmlcontroller.firmarXades(strXML);
                        ManejadorPaneles.showPanelMessageInfo( UtilesMsg.DOC_FIRMADO_OK );
                        dElectronico.getDocumento().setValue( xmlFirmado.getBytes() );  
                        
                    }
                    //validar firma
                    if (isValidar()){
                        ManejadorPaneles.showPanelMessageInfo( UtilesMsg.PROCESANDO_VALIDACION );
                        VerifyResponse v = UtilesWS.getInstancePortValidarWS().validarDocumentoByDoc( dElectronico.getDocumento().getValue(), 
                                                                                    dElectronico.getTipo().getValue() );  
                        if (v.isValida()){
                            ManejadorPaneles.showPanelMessageInfo( UtilesMsg.FIRMA_VERIFICADA_OK );
                        }
                        else{
                            ManejadorPaneles.showPanelMessageInfo( UtilesMsg.ERROR_FIRMA_NO_VALIDA );
                            firmaError( UtilesMsg.ERROR_FIRMA_NO_VALIDA );
                            return;
                        }
                    }
                    else{
                        ManejadorPaneles.showPanelMessageInfo( UtilesMsg.DOC_FIRMADO_OK );
                    }
                    
                    int codigoRespuesta = UtilesWS.getInstancePortWS().guardarDocumento( dElectronico );
                    
                    switch( codigoRespuesta ){
                        case -1:ManejadorPaneles.showPanelMessageError( UtilesMsg.ERROR_GUARDANDO_DOCUMENTO );
                                firmaError( UtilesMsg.ERROR_GUARDANDO_DOCUMENTO );
                                break;
                            
                        case 1: ManejadorPaneles.showPanelMessageInfo( UtilesMsg.DOCUMENTO_GUARDADO_OK );
                                firmaExitosa( UtilesMsg.DOCUMENTO_FIRMADO_GUARDADO_OK );
                                break;
                            
                        default:ManejadorPaneles.showPanelMessageError( UtilesMsg.ERROR_CODIGO_WS );
                                firmaError( UtilesMsg.ERROR_CODIGO_WS );
                        break;
                    }
                }
                catch (AppletException ex) {
                    Logger.getLogger(FirmaPDFController.class.getName()).log(Level.SEVERE, null, ex);
                    ManejadorPaneles.showPanelMessageError( ex.getMsj() );
                    firmaError( ex.getMsj() );
                }
                catch (IOException ex) {
                    Logger.getLogger(FirmaPDFController.class.getName()).log(Level.SEVERE, null, ex);
                    ManejadorPaneles.showPanelMessageError( UtilesMsg.ERROR_ACCEDIENDO_ARCHIVO );
                    firmaError( UtilesMsg.ERROR_ACCEDIENDO_ARCHIVO );
                }
                catch (KeyStoreException ex) {
                    Logger.getLogger(FirmaPDFController.class.getName()).log(Level.SEVERE, null, ex);
                    ManejadorPaneles.showPanelMessageError( UtilesMsg.ERROR_FIRMANDO_DOCUMENTO );
                    firmaError( UtilesMsg.ERROR_FIRMANDO_DOCUMENTO );
                }
                catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(FirmaPDFController.class.getName()).log(Level.SEVERE, null, ex);
                    ManejadorPaneles.showPanelMessageError( UtilesMsg.ERROR_FIRMANDO_DOCUMENTO );
                    firmaError( UtilesMsg.ERROR_FIRMANDO_DOCUMENTO );
                }
                catch (UnrecoverableKeyException ex) {
                    Logger.getLogger(FirmaPDFController.class.getName()).log(Level.SEVERE, null, ex);
                    ManejadorPaneles.showPanelMessageError( UtilesMsg.ERROR_FIRMANDO_DOCUMENTO );
                    firmaError( UtilesMsg.ERROR_FIRMANDO_DOCUMENTO );
                } 
                catch (WSFirmaDocWsException_Exception ex) {         
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    ManejadorPaneles.showPanelMessageError( UtilesMsg.ERROR_SERVICIOS_WEB );
                    firmaError( UtilesMsg.ERROR_SERVICIOS_WEB );
                } 
                catch (ValidarDocWSTXException_Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    ManejadorPaneles.showPanelMessageError( UtilesMsg.ERROR_SERVICIOS_WEB_VALIDACION );
                    firmaError( UtilesMsg.ERROR_SERVICIOS_WEB_VALIDACION );                    
                } 
            }
        };
        thread.start();
        System.out.println("Comienzo de hilo.");
        ManejadorPaneles.showPanelProcesando( nombreDoc );
        
    }    
    
    private void firmaError(String msg){
        JSObject win = (JSObject) JSObject.getWindow(this);
        win.call("firmaError", new String[]{  msg });        
    }
    
    
    private void firmaExitosa( String msj ){  
        JSObject win = (JSObject) JSObject.getWindow(this);
        win.call("firmaExitosa", new String[]{  msj } );   
    }     

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void setFrontPanelSize() {
        setSize(FrontCommon.SIZE_WIDTH, FrontCommon.SIZE_HEIGHT);
    }

    public void setPanels(){
       JPanel card1 = new LoginJPanel();
        JPanel card2 = new ListaCertsJPanel();
        JPanel card3 = new ProcesandoJPanel();
        JPanel card4 = new MensajeJPanel();
        
        ManejadorPaneles.init();
        
        ManejadorPaneles.addPanel(card1, LoginJPanel.class.getName());
        ManejadorPaneles.addPanel(card2, ListaCertsJPanel.class.getName());
        ManejadorPaneles.addPanel(card3, ProcesandoJPanel.class.getName());
        ManejadorPaneles.addPanel(card4, MensajeJPanel.class.getName());
        
        cards = ManejadorPaneles.getInstance().getCards();
        
        this.getContentPane().add( cards );
    }
}
