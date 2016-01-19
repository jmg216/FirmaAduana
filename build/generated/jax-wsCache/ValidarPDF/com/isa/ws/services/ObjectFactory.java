
package com.isa.ws.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.isa.ws.entities.xsd.VerifyResponse;
import com.isa.ws.exceptions.xsd.WServiceTXException;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.isa.ws.services package. 
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

    private final static QName _ValidarDocumentoByDocDataSigned_QNAME = new QName("http://services.ws.isa.com", "dataSigned");
    private final static QName _ValidarPDFWServiceTXExceptionWServiceTXException_QNAME = new QName("http://services.ws.isa.com", "WService_TXException");
    private final static QName _ValidarDocumentoByDocResponseReturn_QNAME = new QName("http://services.ws.isa.com", "return");
    private final static QName _ValidarDocumentoByParamsNombre_QNAME = new QName("http://services.ws.isa.com", "nombre");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.isa.ws.services
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
     * Create an instance of {@link ValidarPDFWServiceTXException }
     * 
     */
    public ValidarPDFWServiceTXException createValidarPDFWServiceTXException() {
        return new ValidarPDFWServiceTXException();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.isa.com", name = "dataSigned", scope = ValidarDocumentoByDoc.class)
    public JAXBElement<String> createValidarDocumentoByDocDataSigned(String value) {
        return new JAXBElement<String>(_ValidarDocumentoByDocDataSigned_QNAME, String.class, ValidarDocumentoByDoc.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WServiceTXException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.isa.com", name = "WService_TXException", scope = ValidarPDFWServiceTXException.class)
    public JAXBElement<WServiceTXException> createValidarPDFWServiceTXExceptionWServiceTXException(WServiceTXException value) {
        return new JAXBElement<WServiceTXException>(_ValidarPDFWServiceTXExceptionWServiceTXException_QNAME, WServiceTXException.class, ValidarPDFWServiceTXException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.isa.com", name = "return", scope = ValidarDocumentoByDocResponse.class)
    public JAXBElement<VerifyResponse> createValidarDocumentoByDocResponseReturn(VerifyResponse value) {
        return new JAXBElement<VerifyResponse>(_ValidarDocumentoByDocResponseReturn_QNAME, VerifyResponse.class, ValidarDocumentoByDocResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.isa.com", name = "return", scope = ValidarDocumentoByParamsResponse.class)
    public JAXBElement<VerifyResponse> createValidarDocumentoByParamsResponseReturn(VerifyResponse value) {
        return new JAXBElement<VerifyResponse>(_ValidarDocumentoByDocResponseReturn_QNAME, VerifyResponse.class, ValidarDocumentoByParamsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ws.isa.com", name = "nombre", scope = ValidarDocumentoByParams.class)
    public JAXBElement<String> createValidarDocumentoByParamsNombre(String value) {
        return new JAXBElement<String>(_ValidarDocumentoByParamsNombre_QNAME, String.class, ValidarDocumentoByParams.class, value);
    }

}
