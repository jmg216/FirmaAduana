
package com.isa.ws.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.isa.ws.exceptions.xsd.WServiceTXException;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WService_TXException" type="{http://exceptions.ws.isa.com/xsd}WService_TXException" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wServiceTXException"
})
@XmlRootElement(name = "ValidarPDFWService_TXException")
public class ValidarPDFWServiceTXException {

    @XmlElementRef(name = "WService_TXException", namespace = "http://services.ws.isa.com", type = JAXBElement.class, required = false)
    protected JAXBElement<WServiceTXException> wServiceTXException;

    /**
     * Obtiene el valor de la propiedad wServiceTXException.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WServiceTXException }{@code >}
     *     
     */
    public JAXBElement<WServiceTXException> getWServiceTXException() {
        return wServiceTXException;
    }

    /**
     * Define el valor de la propiedad wServiceTXException.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WServiceTXException }{@code >}
     *     
     */
    public void setWServiceTXException(JAXBElement<WServiceTXException> value) {
        this.wServiceTXException = value;
    }

}
