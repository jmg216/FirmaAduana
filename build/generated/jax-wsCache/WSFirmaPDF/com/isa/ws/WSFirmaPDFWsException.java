
package com.isa.ws;

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
 *         &lt;element name="WsException" type="{http://exception.isa.com/xsd}WsException" minOccurs="0"/>
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
    "wsException"
})
@XmlRootElement(name = "WSFirmaPDFWsException")
public class WSFirmaPDFWsException {

    @XmlElementRef(name = "WsException", namespace = "http://ws.isa.com", type = JAXBElement.class, required = false)
    protected JAXBElement<WsException> wsException;

    /**
     * Obtiene el valor de la propiedad wsException.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WsException }{@code >}
     *     
     */
    public JAXBElement<WsException> getWsException() {
        return wsException;
    }

    /**
     * Define el valor de la propiedad wsException.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WsException }{@code >}
     *     
     */
    public void setWsException(JAXBElement<WsException> value) {
        this.wsException = value;
    }

}
