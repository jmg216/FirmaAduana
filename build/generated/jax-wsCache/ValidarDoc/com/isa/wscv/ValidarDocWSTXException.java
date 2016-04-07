
package com.isa.wscv;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="WS_TXException" type="{http://exceptions.wsv.isa.com/xsd}WS_TXException" minOccurs="0"/>
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
    "wstxException"
})
@XmlRootElement(name = "ValidarDocWS_TXException")
public class ValidarDocWSTXException {

    @XmlElementRef(name = "WS_TXException", namespace = "http://services.wsv.isa.com", type = JAXBElement.class, required = false)
    protected JAXBElement<WSTXException> wstxException;

    /**
     * Obtiene el valor de la propiedad wstxException.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WSTXException }{@code >}
     *     
     */
    public JAXBElement<WSTXException> getWSTXException() {
        return wstxException;
    }

    /**
     * Define el valor de la propiedad wstxException.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WSTXException }{@code >}
     *     
     */
    public void setWSTXException(JAXBElement<WSTXException> value) {
        this.wstxException = value;
    }

}
