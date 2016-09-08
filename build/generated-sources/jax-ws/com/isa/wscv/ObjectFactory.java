
package com.isa.wscv;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.isa.wscv package. 
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

    private final static QName _ValidarDocumentoByDocResponseReturn_QNAME = new QName("http://services.wsv.isa.com", "return");
    private final static QName _SignatureCn_QNAME = new QName("http://entities.wsv.isa.com/xsd", "cn");
    private final static QName _SignatureFecha_QNAME = new QName("http://entities.wsv.isa.com/xsd", "fecha");
    private final static QName _ValidarDocumentoByDocData_QNAME = new QName("http://services.wsv.isa.com", "data");
    private final static QName _ValidarDocumentoByDocTipo_QNAME = new QName("http://services.wsv.isa.com", "tipo");
    private final static QName _WSTXExceptionMensaje_QNAME = new QName("http://exceptions.wsv.isa.com/xsd", "mensaje");
    private final static QName _ValidarDocWSTXExceptionWSTXException_QNAME = new QName("http://services.wsv.isa.com", "WS_TXException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.isa.wscv
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidarDocumentoByParams }
     * 
     */
    public ValidarDocumentoByParams createValidarDocumentoByParams() {
        return new ValidarDocumentoByParams();
    }

    /**
     * Create an instance of {@link ValidarDocumentoByDocResponse }
     * 
     */
    public ValidarDocumentoByDocResponse createValidarDocumentoByDocResponse() {
        return new ValidarDocumentoByDocResponse();
    }

    /**
     * Create an instance of {@link VerifyResponse }
     * 
     */
    public VerifyResponse createVerifyResponse() {
        return new VerifyResponse();
    }

    /**
     * Create an instance of {@link ValidarDocWSTXException }
     * 
     */
    public ValidarDocWSTXException createValidarDocWSTXException() {
        return new ValidarDocWSTXException();
    }

    /**
     * Create an instance of {@link WSTXException }
     * 
     */
    public WSTXException createWSTXException() {
        return new WSTXException();
    }

    /**
     * Create an instance of {@link ValidarDocumentoByDoc }
     * 
     */
    public ValidarDocumentoByDoc createValidarDocumentoByDoc() {
        return new ValidarDocumentoByDoc();
    }

    /**
     * Create an instance of {@link ValidarDocumentoByParamsResponse }
     * 
     */
    public ValidarDocumentoByParamsResponse createValidarDocumentoByParamsResponse() {
        return new ValidarDocumentoByParamsResponse();
    }

    /**
     * Create an instance of {@link Signature }
     * 
     */
    public Signature createSignature() {
        return new Signature();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.wsv.isa.com", name = "return", scope = ValidarDocumentoByDocResponse.class)
    public JAXBElement<VerifyResponse> createValidarDocumentoByDocResponseReturn(VerifyResponse value) {
        return new JAXBElement<VerifyResponse>(_ValidarDocumentoByDocResponseReturn_QNAME, VerifyResponse.class, ValidarDocumentoByDocResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.wsv.isa.com/xsd", name = "cn", scope = Signature.class)
    public JAXBElement<String> createSignatureCn(String value) {
        return new JAXBElement<String>(_SignatureCn_QNAME, String.class, Signature.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.wsv.isa.com/xsd", name = "fecha", scope = Signature.class)
    public JAXBElement<XMLGregorianCalendar> createSignatureFecha(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_SignatureFecha_QNAME, XMLGregorianCalendar.class, Signature.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.wsv.isa.com", name = "data", scope = ValidarDocumentoByDoc.class)
    public JAXBElement<byte[]> createValidarDocumentoByDocData(byte[] value) {
        return new JAXBElement<byte[]>(_ValidarDocumentoByDocData_QNAME, byte[].class, ValidarDocumentoByDoc.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.wsv.isa.com", name = "tipo", scope = ValidarDocumentoByDoc.class)
    public JAXBElement<String> createValidarDocumentoByDocTipo(String value) {
        return new JAXBElement<String>(_ValidarDocumentoByDocTipo_QNAME, String.class, ValidarDocumentoByDoc.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exceptions.wsv.isa.com/xsd", name = "mensaje", scope = WSTXException.class)
    public JAXBElement<String> createWSTXExceptionMensaje(String value) {
        return new JAXBElement<String>(_WSTXExceptionMensaje_QNAME, String.class, WSTXException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.wsv.isa.com", name = "return", scope = ValidarDocumentoByParamsResponse.class)
    public JAXBElement<VerifyResponse> createValidarDocumentoByParamsResponseReturn(VerifyResponse value) {
        return new JAXBElement<VerifyResponse>(_ValidarDocumentoByDocResponseReturn_QNAME, VerifyResponse.class, ValidarDocumentoByParamsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WSTXException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.wsv.isa.com", name = "WS_TXException", scope = ValidarDocWSTXException.class)
    public JAXBElement<WSTXException> createValidarDocWSTXExceptionWSTXException(WSTXException value) {
        return new JAXBElement<WSTXException>(_ValidarDocWSTXExceptionWSTXException_QNAME, WSTXException.class, ValidarDocWSTXException.class, value);
    }

}
