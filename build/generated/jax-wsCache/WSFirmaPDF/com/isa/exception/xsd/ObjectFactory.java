
package com.isa.exception.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.isa.exception.xsd package. 
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

    private final static QName _WsExceptionMessage_QNAME = new QName("http://exception.isa.com/xsd", "message");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.isa.exception.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WsException }
     * 
     */
    public WsException createWsException() {
        return new WsException();
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
