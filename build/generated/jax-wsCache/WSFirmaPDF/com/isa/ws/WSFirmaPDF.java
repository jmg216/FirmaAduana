
package com.isa.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WSFirmaPDF", targetNamespace = "http://ws.isa.com", wsdlLocation = "http://localhost:8081/WSGetPDF/services/WSFirmaPDF?wsdl")
public class WSFirmaPDF
    extends Service
{

    private final static URL WSFIRMAPDF_WSDL_LOCATION;
    private final static WebServiceException WSFIRMAPDF_EXCEPTION;
    private final static QName WSFIRMAPDF_QNAME = new QName("http://ws.isa.com", "WSFirmaPDF");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/WSGetPDF/services/WSFirmaPDF?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSFIRMAPDF_WSDL_LOCATION = url;
        WSFIRMAPDF_EXCEPTION = e;
    }

    public WSFirmaPDF() {
        super(__getWsdlLocation(), WSFIRMAPDF_QNAME);
    }

    public WSFirmaPDF(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSFIRMAPDF_QNAME, features);
    }

    public WSFirmaPDF(URL wsdlLocation) {
        super(wsdlLocation, WSFIRMAPDF_QNAME);
    }

    public WSFirmaPDF(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSFIRMAPDF_QNAME, features);
    }

    public WSFirmaPDF(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSFirmaPDF(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSFirmaPDFPortType
     */
    @WebEndpoint(name = "WSFirmaPDFHttpSoap11Endpoint")
    public WSFirmaPDFPortType getWSFirmaPDFHttpSoap11Endpoint() {
        return super.getPort(new QName("http://ws.isa.com", "WSFirmaPDFHttpSoap11Endpoint"), WSFirmaPDFPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSFirmaPDFPortType
     */
    @WebEndpoint(name = "WSFirmaPDFHttpSoap11Endpoint")
    public WSFirmaPDFPortType getWSFirmaPDFHttpSoap11Endpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.isa.com", "WSFirmaPDFHttpSoap11Endpoint"), WSFirmaPDFPortType.class, features);
    }

    /**
     * 
     * @return
     *     returns WSFirmaPDFPortType
     */
    @WebEndpoint(name = "WSFirmaPDFHttpSoap12Endpoint")
    public WSFirmaPDFPortType getWSFirmaPDFHttpSoap12Endpoint() {
        return super.getPort(new QName("http://ws.isa.com", "WSFirmaPDFHttpSoap12Endpoint"), WSFirmaPDFPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSFirmaPDFPortType
     */
    @WebEndpoint(name = "WSFirmaPDFHttpSoap12Endpoint")
    public WSFirmaPDFPortType getWSFirmaPDFHttpSoap12Endpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.isa.com", "WSFirmaPDFHttpSoap12Endpoint"), WSFirmaPDFPortType.class, features);
    }

    /**
     * 
     * @return
     *     returns WSFirmaPDFPortType
     */
    @WebEndpoint(name = "WSFirmaPDFHttpEndpoint")
    public WSFirmaPDFPortType getWSFirmaPDFHttpEndpoint() {
        return super.getPort(new QName("http://ws.isa.com", "WSFirmaPDFHttpEndpoint"), WSFirmaPDFPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSFirmaPDFPortType
     */
    @WebEndpoint(name = "WSFirmaPDFHttpEndpoint")
    public WSFirmaPDFPortType getWSFirmaPDFHttpEndpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.isa.com", "WSFirmaPDFHttpEndpoint"), WSFirmaPDFPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSFIRMAPDF_EXCEPTION!= null) {
            throw WSFIRMAPDF_EXCEPTION;
        }
        return WSFIRMAPDF_WSDL_LOCATION;
    }

}