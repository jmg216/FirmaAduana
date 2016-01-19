
package com.isa.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.isa.exception.xsd.WsException;
import com.isa.ws.xsd.PDF;


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

    private final static QName _GuardarPDFPdf_QNAME = new QName("http://ws.isa.com", "pdf");
    private final static QName _WSFirmaPDFWsExceptionWsException_QNAME = new QName("http://ws.isa.com", "WsException");
    private final static QName _ObtenerPDFParaFirmarNombre_QNAME = new QName("http://ws.isa.com", "nombre");
    private final static QName _ObtenerPDFParaFirmarResponseReturn_QNAME = new QName("http://ws.isa.com", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.isa.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GuardarPDF }
     * 
     */
    public GuardarPDF createGuardarPDF() {
        return new GuardarPDF();
    }

    /**
     * Create an instance of {@link ObtenerPDFParaValidar }
     * 
     */
    public ObtenerPDFParaValidar createObtenerPDFParaValidar() {
        return new ObtenerPDFParaValidar();
    }

    /**
     * Create an instance of {@link WSFirmaPDFWsException }
     * 
     */
    public WSFirmaPDFWsException createWSFirmaPDFWsException() {
        return new WSFirmaPDFWsException();
    }

    /**
     * Create an instance of {@link GuardarPDFResponse }
     * 
     */
    public GuardarPDFResponse createGuardarPDFResponse() {
        return new GuardarPDFResponse();
    }

    /**
     * Create an instance of {@link ObtenerPDFParaValidarResponse }
     * 
     */
    public ObtenerPDFParaValidarResponse createObtenerPDFParaValidarResponse() {
        return new ObtenerPDFParaValidarResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PDF }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.isa.com", name = "pdf", scope = GuardarPDF.class)
    public JAXBElement<PDF> createGuardarPDFPdf(PDF value) {
        return new JAXBElement<PDF>(_GuardarPDFPdf_QNAME, PDF.class, GuardarPDF.class, value);
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
    @XmlElementDecl(namespace = "http://ws.isa.com", name = "nombre", scope = ObtenerPDFParaValidar.class)
    public JAXBElement<String> createObtenerPDFParaValidarNombre(String value) {
        return new JAXBElement<String>(_ObtenerPDFParaFirmarNombre_QNAME, String.class, ObtenerPDFParaValidar.class, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PDF }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.isa.com", name = "return", scope = ObtenerPDFParaValidarResponse.class)
    public JAXBElement<PDF> createObtenerPDFParaValidarResponseReturn(PDF value) {
        return new JAXBElement<PDF>(_ObtenerPDFParaFirmarResponseReturn_QNAME, PDF.class, ObtenerPDFParaValidarResponse.class, value);
    }

}
