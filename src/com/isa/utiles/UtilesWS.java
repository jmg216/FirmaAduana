/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.utiles;

import com.isa.ws.WSFirmaPDF;
import com.isa.ws.WSFirmaPDFPortType;
import java.io.IOException;
import java.net.URL;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author JMiraballes
 */
public class UtilesWS {
    
    private static WSFirmaPDFPortType port = null;
    public static int CODIGO_RESPUESTA_ERROR = -1; 
    public static int CODIGO_RESPUESTA_OK = 1; 
            
    private UtilesWS(){}
    
    
    
    public static WSFirmaPDFPortType getInstancePortWS() throws IOException{
        if (port == null){
            //URL wsdllocation = new URL(UtilesResources.getProperty(UtilesResources.PROP_WS_ENDPOINT));
            WSFirmaPDF wsFirmarPDF = new WSFirmaPDF();
            port = wsFirmarPDF.getWSFirmaPDFHttpEndpoint();
            BindingProvider bindingProvider = (BindingProvider) port; 
            bindingProvider.getRequestContext().put( BindingProvider.ENDPOINT_ADDRESS_PROPERTY, UtilesResources.getProperty(UtilesResources.PROP_WS_ENDPOINT) );
            if (UtilesResources.TRUE_VALUE.equals(UtilesResources.getProperty(UtilesResources.PROP_WS_AUTH))){
                bindingProvider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, UtilesResources.getProperty(UtilesResources.PROP_WS_USER));
                bindingProvider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, UtilesResources.getProperty(UtilesResources.PROP_WS_PASSWD));
            }
        }
        return port;
    }
    
}
