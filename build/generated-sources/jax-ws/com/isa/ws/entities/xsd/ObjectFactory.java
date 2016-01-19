
package com.isa.ws.entities.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.isa.ws.entities.xsd package. 
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

    private final static QName _SignatureFecha_QNAME = new QName("http://entities.ws.isa.com/xsd", "fecha");
    private final static QName _SignatureCn_QNAME = new QName("http://entities.ws.isa.com/xsd", "cn");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.isa.ws.entities.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VerifyResponse }
     * 
     */
    public VerifyResponse createVerifyResponse() {
        return new VerifyResponse();
    }

    /**
     * Create an instance of {@link Signature }
     * 
     */
    public Signature createSignature() {
        return new Signature();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.ws.isa.com/xsd", name = "fecha", scope = Signature.class)
    public JAXBElement<XMLGregorianCalendar> createSignatureFecha(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_SignatureFecha_QNAME, XMLGregorianCalendar.class, Signature.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entities.ws.isa.com/xsd", name = "cn", scope = Signature.class)
    public JAXBElement<String> createSignatureCn(String value) {
        return new JAXBElement<String>(_SignatureCn_QNAME, String.class, Signature.class, value);
    }

}
