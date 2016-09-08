/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.firma.xades;

import com.isa.common.ActualCertInfo;
import com.isa.exception.AppletException;
import com.isa.token.HandlerToken;
import com.isa.token.Token;
import com.isa.utiles.Utiles;
import com.isa.utiles.UtilesResources;
import java.security.AccessControlException;
import java.security.KeyStoreException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import xades4j.XAdES4jException;
import xades4j.algorithms.EnvelopedSignatureTransform;
import xades4j.production.DataObjectReference;
import xades4j.production.EnvelopedXmlObject;
import xades4j.production.SignedDataObjects;
import xades4j.production.XadesBesSigningProfile;
import xades4j.production.XadesSignatureResult;
import xades4j.production.XadesSigner;
import xades4j.production.XadesSigningProfile;
import xades4j.properties.DataObjectDesc;
import xades4j.providers.BasicSignatureOptionsProvider;
import xades4j.providers.KeyingDataProvider;
import xades4j.providers.impl.DefaultBasicSignatureOptionsProvider;
import xades4j.providers.impl.PKCS11KeyStoreKeyingDataProvider;

/**
 *
 * @author JMiraballes
 */
public class FirmaXMLController {    
    
    private static FirmaXMLController firmaXMLController;
    private XMLFirma xmlfirma;
    
    public FirmaXMLController(){}
    
    public static FirmaXMLController getInstance(){
        if (firmaXMLController == null){
            firmaXMLController = new FirmaXMLController();
        }
        return firmaXMLController;
    }
    
    public String firmarXades(String dataToSign ) throws AppletException {
        try{
            HandlerToken handler = ActualCertInfo.getInstance().getHandler();
            Token token = handler.getTokenActivo();
            KeyingDataProvider kp = new PKCS11KeyStoreKeyingDataProvider(
                                            token.getLibrary() + 
                                            "\nshowInfo=true", 
                                            token.getModule(),
                                            new CertificateSelector( ActualCertInfo.getInstance().getCertIndex() ),
                                            new DirectPasswordProvider( ActualCertInfo.getInstance().getPassword()),
                                            null,
                                            true );
            XadesSigningProfile p = new XadesBesSigningProfile( kp ).withBasicSignatureOptionsProvider(new BasicSignatureOptionsProvider() {
                @Override
                public boolean includeSigningCertificate() {
                    return true;
                }

                @Override
                public boolean includePublicKey() {
                    return true;
                }

                @Override
                public boolean signSigningCertificate() {
                    return false;
                }
            });
            
            XadesSigner signer = p.newSigner();
            System.out.println("Se crea nodo a firmar.");
            NodoFirma nodoFirma = new NodoFirma( dataToSign );
            Document doc = nodoFirma.getDocument();

            System.out.println("******* Previo a firmar ***************");
            XadesSignatureResult result  = getXmlfirma().firmar(signer, doc);
            System.out.println("******** Firmado **************");
            String xmlSignature = Utiles.printDocument(result.getSignature().getDocument());

            return xmlSignature;
        }
        catch(AccessControlException e){
            e.printStackTrace();
            throw new AppletException(e.getMessage(), null, e.getCause());
        }        
        catch(XAdES4jException e ){
            e.printStackTrace();
            throw new AppletException(e.getMessage(), null, e.getCause());
        } 
        catch (KeyStoreException e) {
            Logger.getLogger(FirmaXMLController.class.getName()).log(Level.SEVERE, null, e);
            throw new AppletException(e.getMessage(), null, e.getCause());
        }  
        catch (Exception e){
            Logger.getLogger(FirmaXMLController.class.getName()).log(Level.SEVERE, null, e);
            throw new AppletException(e.getMessage(), null, e.getCause());
        }
    }
    
    public void generateInfoFirma() throws AppletException {
        System.out.println("FirmaXMLController::getInfoFirma");
        try{
            HandlerToken handler = ActualCertInfo.getInstance().getHandler();
            Token token = handler.getTokenActivo();
            HashMap aliasHash = ActualCertInfo.getInstance().getAliasHash();
            int certIndex = ActualCertInfo.getInstance().getCertIndex();
            String alias = (String) aliasHash.get(certIndex);            
            
            XMLFirma xmlfirma = new XMLFirma();
            xmlfirma.setChainCert( token.getKeystore().getCertificateChain(alias) );
            xmlfirma.setProvidername( token.getKeystore().getProvider().getName() );
            //Definiendo apariencia de firma.        
            X509Certificate c = (X509Certificate) token.getKeystore().getCertificate(alias);
            xmlfirma.setNroSerie( Utiles.getSerialNumber( c.getSubjectDN().getName()) );
            xmlfirma.setDn(c.getSubjectDN().getName());
            xmlfirma.setFirmante(Utiles.getCN(c.getSubjectDN().getName()));
            this.xmlfirma = xmlfirma;
        }
        catch (KeyStoreException e){
            e.printStackTrace();
            throw new AppletException("Error al obtener información para firmas xades.", null, e.getCause());
        }
        
    }

    public XMLFirma getXmlfirma() {
        return xmlfirma;
    }

    public void setXmlfirma(XMLFirma xmlfirma) {
        this.xmlfirma = xmlfirma;
    }
    
    
    
}
