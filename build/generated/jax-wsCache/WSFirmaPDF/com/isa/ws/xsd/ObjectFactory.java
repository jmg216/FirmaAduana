
package com.isa.ws.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.isa.ws.xsd package. 
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

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.isa.ws.xsd
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

}
