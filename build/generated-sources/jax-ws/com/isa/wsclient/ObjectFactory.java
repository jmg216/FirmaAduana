
package com.isa.wsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.isa.wsclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GuardarDocumentoDocumento_QNAME = new QName("http://ws.isa.com", "documento");
    private final static QName _ObtenerDocumentoParaValidarResponseReturn_QNAME = new QName("http://ws.isa.com", "return");
    private final static QName _WsExceptionMessage_QNAME = new QName("http://exception.isa.com/xsd", "message");
    private final static QName _WSFirmaDocWsExceptionWsException_QNAME = new QName("http://ws.isa.com", "WsException");
    private final static QName _DocumentoName_QNAME = new QName("http://entities.isa.com/xsd", "name");
    private final static QName _DocumentoDocumento_QNAME = new QName("http://entities.isa.com/xsd", "documento");
    private final static QName _DocumentoTipo_QNAME = new QName("http://entities.isa.com/xsd", "tipo");
    private final static QName _DocumentoExt_QNAME = new QName("http://entities.isa.com/xsd", "ext");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.isa.wsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Documento }
     * 
     */
    public Documento createDocumento() {
        return new Documento();
    }

    /**
     * Create an instance of {@link ObtenerDocumentoParaFirmarResponse }
     * 
     */
    public ObtenerDocumentoParaFirmarResponse createObtenerDocumentoParaFirmarResponse() {
        return new ObtenerDocumentoParaFirmarResponse();
    }

    /**
     * Create an instance of {@link GuardarDocumento }
     * 
     */
    public GuardarDocumento createGuardarDocumento() {
        return new GuardarDocumento();
    }

    /**
     * Create an instance of {@link ObtenerDocumentoParaValidarResponse }
     * 
     */
    public ObtenerDocumentoParaValidarResponse createObtenerDocumentoParaValidarResponse() {
        return new ObtenerDocumentoParaValidarResponse();
    }

    /**
     * Create an instance of {@link ObtenerDocumentoParaValidar }
     * 
     */
    public ObtenerDocumentoParaValidar createObtenerDocumentoParaValidar() {
        return new ObtenerDocumentoParaValidar();
    }

    /**
     * Create an instance of {@link WSFirmaDocWsException }
     * 
     */
    public WSFirmaDocWsException createWSFirmaDocWsException() {
        return new WSFirmaDocWsException();
    }

    /**
     * Create an instance of {@link WsException }
     * 
     */
    public WsException createWsException() {
        return new WsException();
    }

    /**
     * Create an instance of {@link GuardarDocumentoResponse }
     * 
     */
    public GuardarDocumentoResponse createGuardarDocumentoResponse() {
        return new GuardarDocumentoResponse();
    }

    /**
     * Create an instance of {@link ObtenerDocumentoParaFirmar }
     * 
     */
    public ObtenerDocumentoParaFirmar createObtenerDocumentoParaFirmar() {
        return new ObtenerDocumentoParaFirmar();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Documento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.isa.com", name = "documento", scope = GuardarDocumento.class)
    public JAXBElement<Documento> createGuardarDocumentoDocumento(Documento value) {
        return new JAXBElement<Documento>(_GuardarDocumentoDocumento_QNAME, Documento.class, GuardarDocumento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Documento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.isa.com", name = "return", scope = ObtenerDocumentoParaValidarResponse.class)
    public JAXBElement<Documento> createObtenerDocumentoParaValidarResponseReturn(Documento value) {
        return new JAXBElement<Documento>(_ObtenerDocumentoParaValidarResponseReturn_QNAME, Documento.class, ObtenerDocumentoParaValidarResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Documento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.isa.com", name = "return", scope = ObtenerDocumentoParaFirmarResponse.class)
    public JAXBElement<Documento> createObtenerDocumentoParaFirmarResponseReturn(Documento value) {
        return new JAXBElement<Documento>(_ObtenerDocumentoParaValidarResponseReturn_QNAME, Documento.class, ObtenerDocumentoParaFirmarResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exception.isa.com/xsd", name = "message", scope = WsException.class)
    public JAXBElement<String> createWsExceptionMessage(String value) {
        return new JAXBElement<String>(_WsExceptionMessage_QNAME, String.class, WsException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WsException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.isa.com", name = "WsException", scope = WSFirmaDocWsException.class)
    public JAXBElement<WsException> createWSFirmaDocWsExceptionWsException(WsException value) {
        return new JAXBElement<WsException>(_WSFirmaDocWsExceptionWsException_QNAME, WsException.class, WSFirmaDocWsException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.isa.com/xsd", name = "name", scope = Documento.class)
    public JAXBElement<String> createDocumentoName(String value) {
        return new JAXBElement<String>(_DocumentoName_QNAME, String.class, Documento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.isa.com/xsd", name = "documento", scope = Documento.class)
    public JAXBElement<byte[]> createDocumentoDocumento(byte[] value) {
        return new JAXBElement<byte[]>(_DocumentoDocumento_QNAME, byte[].class, Documento.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.isa.com/xsd", name = "tipo", scope = Documento.class)
    public JAXBElement<String> createDocumentoTipo(String value) {
        return new JAXBElement<String>(_DocumentoTipo_QNAME, String.class, Documento.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.isa.com/xsd", name = "ext", scope = Documento.class)
    public JAXBElement<String> createDocumentoExt(String value) {
        return new JAXBElement<String>(_DocumentoExt_QNAME, String.class, Documento.class, value);
    }

}
