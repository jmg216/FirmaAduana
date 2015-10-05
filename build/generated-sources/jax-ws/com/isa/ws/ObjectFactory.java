
package com.isa.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.isa.ws package. 
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

    private final static QName _PDFName_QNAME = new QName("http://ws.isa.com/xsd", "name");
    private final static QName _PDFDocumento_QNAME = new QName("http://ws.isa.com/xsd", "documento");
    private final static QName _ObtenerPDFParaFirmarResponseReturn_QNAME = new QName("http://ws.isa.com", "return");
    private final static QName _WSFirmaPDFWsExceptionWsException_QNAME = new QName("http://ws.isa.com", "WsException");
    private final static QName _GuardarPDFParaFirmarPdf_QNAME = new QName("http://ws.isa.com", "pdf");
    private final static QName _ObtenerPDFParaFirmarNombre_QNAME = new QName("http://ws.isa.com", "nombre");
    private final static QName _WsExceptionMessage_QNAME = new QName("http://exception.isa.com/xsd", "message");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.isa.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PDF }
     * 
     */
    public PDF createPDF() {
        return new PDF();
    }

    /**
     * Create an instance of {@link WsException }
     * 
     */
    public WsException createWsException() {
        return new WsException();
    }

    /**
     * Create an instance of {@link GuardarPDFParaFirmarResponse }
     * 
     */
    public GuardarPDFParaFirmarResponse createGuardarPDFParaFirmarResponse() {
        return new GuardarPDFParaFirmarResponse();
    }

    /**
     * Create an instance of {@link GuardarPDFParaFirmar }
     * 
     */
    public GuardarPDFParaFirmar createGuardarPDFParaFirmar() {
        return new GuardarPDFParaFirmar();
    }

    /**
     * Create an instance of {@link WSFirmaPDFWsException }
     * 
     */
    public WSFirmaPDFWsException createWSFirmaPDFWsException() {
        return new WSFirmaPDFWsException();
    }

    /**
     * Create an instance of {@link ObtenerPDFParaFirmarResponse }
     * 
     */
    public ObtenerPDFParaFirmarResponse createObtenerPDFParaFirmarResponse() {
        return new ObtenerPDFParaFirmarResponse();
    }

    /**
     * Create an instance of {@link ObtenerPDFParaFirmar }
     * 
     */
    public ObtenerPDFParaFirmar createObtenerPDFParaFirmar() {
        return new ObtenerPDFParaFirmar();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.isa.com/xsd", name = "name", scope = PDF.class)
    public JAXBElement<String> createPDFName(String value) {
        return new JAXBElement<String>(_PDFName_QNAME, String.class, PDF.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.isa.com/xsd", name = "documento", scope = PDF.class)
    public JAXBElement<byte[]> createPDFDocumento(byte[] value) {
        return new JAXBElement<byte[]>(_PDFDocumento_QNAME, byte[].class, PDF.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PDF }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.isa.com", name = "return", scope = ObtenerPDFParaFirmarResponse.class)
    public JAXBElement<PDF> createObtenerPDFParaFirmarResponseReturn(PDF value) {
        return new JAXBElement<PDF>(_ObtenerPDFParaFirmarResponseReturn_QNAME, PDF.class, ObtenerPDFParaFirmarResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WsException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.isa.com", name = "WsException", scope = WSFirmaPDFWsException.class)
    public JAXBElement<WsException> createWSFirmaPDFWsExceptionWsException(WsException value) {
        return new JAXBElement<WsException>(_WSFirmaPDFWsExceptionWsException_QNAME, WsException.class, WSFirmaPDFWsException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PDF }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.isa.com", name = "pdf", scope = GuardarPDFParaFirmar.class)
    public JAXBElement<PDF> createGuardarPDFParaFirmarPdf(PDF value) {
        return new JAXBElement<PDF>(_GuardarPDFParaFirmarPdf_QNAME, PDF.class, GuardarPDFParaFirmar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.isa.com", name = "nombre", scope = ObtenerPDFParaFirmar.class)
    public JAXBElement<String> createObtenerPDFParaFirmarNombre(String value) {
        return new JAXBElement<String>(_ObtenerPDFParaFirmarNombre_QNAME, String.class, ObtenerPDFParaFirmar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exception.isa.com/xsd", name = "message", scope = WsException.class)
    public JAXBElement<String> createWsExceptionMessage(String value) {
        return new JAXBElement<String>(_WsExceptionMessage_QNAME, String.class, WsException.class, value);
    }

}
