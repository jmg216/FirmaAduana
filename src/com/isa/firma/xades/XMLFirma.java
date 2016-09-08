package com.isa.firma.xades;

import com.isa.firma.folder.Firma;
import com.isa.utiles.UtilesResources;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xml.security.utils.Constants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import xades4j.XAdES4jException;
import xades4j.algorithms.EnvelopedSignatureTransform;
import xades4j.production.DataObjectReference;
import xades4j.production.EnvelopedXmlObject;
import xades4j.production.SignedDataObjects;
import xades4j.production.XadesSignatureResult;
import xades4j.production.XadesSigner;
import xades4j.properties.DataObjectDesc;
import xades4j.utils.DOMHelper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JMiraballes
 */
public class XMLFirma extends Firma{
    
    private PrivateKey pk;
    private Certificate[] chainCert;
    private String providername;
    private String dn;
    private String firmante;
    private String nroSerie;
    private int tipoFirma;
    
    

    public PrivateKey getPk() {
        return pk;
    }

    public void setPk(PrivateKey pk) {
        this.pk = pk;
    }

    public Certificate[] getChainCert() {
        return chainCert;
    }

    public void setChainCert(Certificate[] chainCert) {
        this.chainCert = chainCert;
    }

    public String getProvidername() {
        return providername;
    }

    public void setProvidername(String providername) {
        this.providername = providername;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public String getFirmante() {
        return firmante;
    }

    public void setFirmante(String firmante) {
        this.firmante = firmante;
    }

    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    } 

    public int getTipoFirma() {
        return tipoFirma;
    }

    public void setTipoFirma(int tipoFirma) {
        this.tipoFirma = tipoFirma;
    }
    
    public boolean isFirmaEnveloped(){
        return XMLFirma.XADES_ENVED == this.tipoFirma;
    }
    
    public boolean isFirmaEnveloping(){
        return XMLFirma.XADES_ENVING == this.tipoFirma;
    }
    
    public boolean isFirmaDetached(){
        return XMLFirma.XADES_DETACHED == this.tipoFirma;
    }
    
    public XadesSignatureResult firmar(XadesSigner signer, Document doc) throws XAdES4jException, ParserConfigurationException, IOException{
        System.out.println("FirmaXMLController::firmar");
        if (isFirmaEnveloped()){
            return firmarXAdesEnveloped(signer, doc);
        }
        else if (isFirmaEnveloping()){
            return firmarXAdesEnveloping(signer, doc);
        }
        else if (isFirmaDetached()){
            return firmarXAdESInternallyDetached(signer, doc);
        }
        else return null;
    }

    

    public XadesSignatureResult firmarXAdesEnveloped( XadesSigner signer, Document doc) throws XAdES4jException{
        System.out.println("FirmaXMLController::firmarXAdesEnveloped");
        DataObjectDesc obj1 = new DataObjectReference("").withTransform(new EnvelopedSignatureTransform());
        SignedDataObjects so = new SignedDataObjects(obj1);
        
        return signer.sign(so, doc.getDocumentElement());
    }
    
    public XadesSignatureResult firmarXAdesEnveloping(XadesSigner signer, Document doc) throws XAdES4jException{
        System.out.println("FirmaXMLController::firmarXAdesEnveloping");
        DataObjectDesc obj = new EnvelopedXmlObject(doc.getDocumentElement(), "text/plain", "http://www.w3.org/2000/09/xmldsig#");
        SignedDataObjects dataObjs = new SignedDataObjects(obj);                
        return signer.sign(dataObjs, doc);
    }
    
    public XadesSignatureResult firmarXAdESInternallyDetached(XadesSigner signer, Document doc) throws XAdES4jException, ParserConfigurationException, IOException{
        System.out.println("FirmaXMLController::firmarXAdESDetached");        
        Element element = doc.getDocumentElement();
        System.out.println("Tiene atributo ns: " + doc.getDocumentElement().hasAttributeNS(null, Constants._ATT_ID));
        System.out.println("Tag name: " + doc.getDocumentElement().getTagName());
        String idtagnamme = null;
        // no tiene container
        String intenallyDetachedTag = UtilesResources.getProperty( UtilesResources.TAG_INTENALLY_DETACHED);
        if (doc.getElementsByTagName( intenallyDetachedTag ).getLength() == 0){
            System.out.println("No contiene: " + intenallyDetachedTag);            
            //se crea nuevo nodo
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Node oldRoot = doc.getDocumentElement();
            Document newDoc = builder.newDocument();
            Element newRoot = newDoc.createElement( intenallyDetachedTag );
            newDoc.appendChild(newRoot);
            newRoot.appendChild(newDoc.importNode(oldRoot, true));
            
            element = newRoot;
            doc = newDoc;
                
            Element ele = DOMHelper.getFirstChildElement(doc.getFirstChild());
            System.out.println("FirstChildNode: " + ele.getTagName());
            System.out.println("FirstChildNodeEle2: " + ele.getTagName());
            DOMHelper.setIdAsXmlId(ele, ele.getTagName());
            DOMHelper.useIdAsXmlId(ele);   
            idtagnamme = ele.getTagName();  
        }   
        else{
            Element ele = DOMHelper.getFirstChildElement(doc.getFirstChild());
            System.out.println("FirstChildNode: " + ele.getTagName());
            DOMHelper.useIdAsXmlId(ele);
            idtagnamme = ele.getTagName();
        }
            
        System.out.println("ID Tag name: " + idtagnamme);
        SignedDataObjects objs = new SignedDataObjects(new DataObjectReference("#" + idtagnamme));
        return signer.sign(objs, element);
    }   
}
