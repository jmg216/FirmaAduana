
package com.isa.wscv;

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
@WebServiceClient(name = "ValidarDoc", targetNamespace = "http://services.wsv.isa.com", wsdlLocation = "http://localhost:8181/WSAduana_TX/services/ValidarDoc?wsdl")
public class ValidarDoc
    extends Service
{

    private final static URL VALIDARDOC_WSDL_LOCATION;
    private final static WebServiceException VALIDARDOC_EXCEPTION;
    private final static QName VALIDARDOC_QNAME = new QName("http://services.wsv.isa.com", "ValidarDoc");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8181/WSAduana_TX/services/ValidarDoc?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        VALIDARDOC_WSDL_LOCATION = url;
        VALIDARDOC_EXCEPTION = e;
    }

    public ValidarDoc() {
        super(__getWsdlLocation(), VALIDARDOC_QNAME);
    }

    public ValidarDoc(WebServiceFeature... features) {
        super(__getWsdlLocation(), VALIDARDOC_QNAME, features);
    }

    public ValidarDoc(URL wsdlLocation) {
        super(wsdlLocation, VALIDARDOC_QNAME);
    }

    public ValidarDoc(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, VALIDARDOC_QNAME, features);
    }

    public ValidarDoc(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ValidarDoc(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ValidarDocPortType
     */
    @WebEndpoint(name = "ValidarDocHttpSoap11Endpoint")
    public ValidarDocPortType getValidarDocHttpSoap11Endpoint() {
        return super.getPort(new QName("http://services.wsv.isa.com", "ValidarDocHttpSoap11Endpoint"), ValidarDocPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ValidarDocPortType
     */
    @WebEndpoint(name = "ValidarDocHttpSoap11Endpoint")
    public ValidarDocPortType getValidarDocHttpSoap11Endpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.wsv.isa.com", "ValidarDocHttpSoap11Endpoint"), ValidarDocPortType.class, features);
    }

    /**
     * 
     * @return
     *     returns ValidarDocPortType
     */
    @WebEndpoint(name = "ValidarDocHttpSoap12Endpoint")
    public ValidarDocPortType getValidarDocHttpSoap12Endpoint() {
        return super.getPort(new QName("http://services.wsv.isa.com", "ValidarDocHttpSoap12Endpoint"), ValidarDocPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ValidarDocPortType
     */
    @WebEndpoint(name = "ValidarDocHttpSoap12Endpoint")
    public ValidarDocPortType getValidarDocHttpSoap12Endpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.wsv.isa.com", "ValidarDocHttpSoap12Endpoint"), ValidarDocPortType.class, features);
    }

    /**
     * 
     * @return
     *     returns ValidarDocPortType
     */
    @WebEndpoint(name = "ValidarDocHttpEndpoint")
    public ValidarDocPortType getValidarDocHttpEndpoint() {
        return super.getPort(new QName("http://services.wsv.isa.com", "ValidarDocHttpEndpoint"), ValidarDocPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ValidarDocPortType
     */
    @WebEndpoint(name = "ValidarDocHttpEndpoint")
    public ValidarDocPortType getValidarDocHttpEndpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.wsv.isa.com", "ValidarDocHttpEndpoint"), ValidarDocPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (VALIDARDOC_EXCEPTION!= null) {
            throw VALIDARDOC_EXCEPTION;
        }
        return VALIDARDOC_WSDL_LOCATION;
    }

}
