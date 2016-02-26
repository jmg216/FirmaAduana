/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.firma.xades;

import com.isa.common.ActualCertInfo;
import com.isa.exception.AppletException;
import com.isa.utiles.Utiles;
import com.isa.utiles.UtilesResources;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.KeyStoreException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import xades4j.XAdES4jException;
import xades4j.algorithms.EnvelopedSignatureTransform;
import xades4j.production.DataObjectReference;
import xades4j.production.Enveloped;
import xades4j.production.SignedDataObjects;
import xades4j.production.XadesBesSigningProfile;
import xades4j.production.XadesSignatureResult;
import xades4j.production.XadesSigner;
import xades4j.production.XadesSigningProfile;
import xades4j.properties.CommitmentTypeProperty;
import xades4j.properties.DataObjectDesc;
import xades4j.providers.KeyingDataProvider;
import xades4j.providers.impl.PKCS11KeyStoreKeyingDataProvider;

/**
 *
 * @author JMiraballes
 */
public class FirmaXMLController {    
    
    private static FirmaXMLController firmaXMLController;
    
    public FirmaXMLController(){}
    
    public static FirmaXMLController getInstance(){
        if (firmaXMLController == null){
            firmaXMLController = new FirmaXMLController();
        }
        return firmaXMLController;
    }
    
    public String firmarXades( String dataToSign ) throws AppletException {
        try{

                
            KeyingDataProvider kp = new PKCS11KeyStoreKeyingDataProvider(
                                            UtilesResources.getProperty("appletConfig.LibrariesWin") + 
                                            "\nshowInfo=true", 
                                            UtilesResources.getProperty("appletConfig.Modulos"),
                                            new CertificateSelector( ActualCertInfo.getInstance().getCertIndex() ),
                                            new DirectPasswordProvider( ActualCertInfo.getInstance().getPassword()),
                                            null,
                                            true );
            System.out.println("Se instancia PKCS11.");
            
            XadesSigningProfile p = new XadesBesSigningProfile( kp );
            XadesSigner signer = p.newSigner();
            AlgorithmsProvider algorithmProvider = new AlgorithmsProvider();
            p.withAlgorithmsProviderEx( algorithmProvider );
       
            System.out.println("Se crea nodo a firmar.");
            NodoFirma nodoFirma = new NodoFirma( dataToSign );
            Document doc = nodoFirma.getDocument();
            
            //data object reference.
            System.out.println("******* Previo a firmar ***************");
            //new Enveloped(signer).sign( doc.getDocumentElement() );
            DataObjectDesc obj1 = new DataObjectReference("")
                .withTransform(new EnvelopedSignatureTransform());
            XadesSignatureResult result = signer.sign(new SignedDataObjects(obj1), doc.getDocumentElement());
            System.out.println("******** Firmado **************");
            String xmlSignature = Utiles.printDocument(result.getSignature().getDocument());
            //String xmlSignatureBase64 = org.apache.xml.security.utils.Base64.encode(xmlSignature.getBytes());
            return xmlSignature;
        }
        
        catch( IOException e){
            e.printStackTrace();
            throw new AppletException("Error accediendo a archivos de properties", null, e.getCause());        
        }
        catch(AccessControlException e){
            e.printStackTrace();
            throw new AppletException("", null, e.getCause());
        }        
        catch(XAdES4jException e ){
            e.printStackTrace();
            throw new AppletException("", null, e.getCause());
        } 
        catch (KeyStoreException e) {
            Logger.getLogger(FirmaXMLController.class.getName()).log(Level.SEVERE, null, e);
            throw new AppletException("", null, e.getCause());
        }  
        
    }
}
