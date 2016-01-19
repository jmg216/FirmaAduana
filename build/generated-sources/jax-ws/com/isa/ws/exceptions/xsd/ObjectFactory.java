
package com.isa.ws.exceptions.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.isa.ws.exceptions.xsd package. 
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

    private final static QName _WServiceTXExceptionMensaje_QNAME = new QName("http://exceptions.ws.isa.com/xsd", "mensaje");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.isa.ws.exceptions.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WServiceTXException }
     * 
     */
    public WServiceTXException createWServiceTXException() {
        return new WServiceTXException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exceptions.ws.isa.com/xsd", name = "mensaje", scope = WServiceTXException.class)
    public JAXBElement<String> createWServiceTXExceptionMensaje(String value) {
        return new JAXBElement<String>(_WServiceTXExceptionMensaje_QNAME, String.class, WServiceTXException.class, value);
    }

}
