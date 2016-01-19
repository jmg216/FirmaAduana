/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.utiles;

import com.isa.ws.WSFirmaPDF;
import com.isa.ws.WSFirmaPDFPortType;
import com.isa.ws.services.ValidarPDF;
import com.isa.ws.services.ValidarPDFPortType;
import java.io.IOException;
import java.net.URL;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author JMiraballes
 */
public class UtilesWS {
    
    private static WSFirmaPDFPortType port = null;
    private static ValidarPDFPortType portvalida = null;
    
    public static int CODIGO_RESPUESTA_ERROR = -1; 
    public static int CODIGO_RESPUESTA_OK = 1; 
            
    private UtilesWS(){}
    
    public static ValidarPDFPortType getInstancePortValidarWS() throws IOException{
        if (portvalida == null){
            URL wsdllocation = new URL(UtilesResources.getProperty(UtilesResources.PROP_WS_ENDPOINT_VALIDACION));
            ValidarPDF servicio = new ValidarPDF( wsdllocation );
            portvalida = servicio.getValidarPDFHttpSoap12Endpoint();
            BindingProvider bindingProvider = (BindingProvider) portvalida; 
            bindingProvider.getRequestContext().put( BindingProvider.ENDPOINT_ADDRESS_PROPERTY, UtilesResources.getProperty(UtilesResources.PROP_WS_ENDPOINT_VALIDACION) );
        }
        return portvalida;        
    }
    
    public static WSFirmaPDFPortType getInstancePortWS() throws IOException{
        if (port == null){
            URL wsdllocation = new URL(UtilesResources.getProperty(UtilesResources.PROP_WS_ENDPOINT));
            WSFirmaPDF servicio = new WSFirmaPDF( wsdllocation );
            port = servicio.getWSFirmaPDFHttpSoap12Endpoint();
            BindingProvider bindingProvider = (BindingProvider) port; 
            bindingProvider.getRequestContext().put( BindingProvider.ENDPOINT_ADDRESS_PROPERTY, UtilesResources.getProperty(UtilesResources.PROP_WS_ENDPOINT) );
        }
        return port;
    }
    
}
