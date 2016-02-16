/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.utiles;

import com.isa.wsclient.WSFirmaDoc;
import com.isa.wsclient.WSFirmaDocPortType;
import com.isa.wscv.ValidarDoc;
import com.isa.wscv.ValidarDocPortType;
import java.io.IOException;
import java.net.URL;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author JMiraballes
 */
public class UtilesWS {
    
    private static WSFirmaDocPortType port = null;
    private static ValidarDocPortType portvalida = null;
    
    public static int CODIGO_RESPUESTA_ERROR = -1; 
    public static int CODIGO_RESPUESTA_OK = 1; 
            
    private UtilesWS(){}
    
    public static ValidarDocPortType getInstancePortValidarWS() throws IOException{
        if (portvalida == null){
            URL wsdllocation = new URL(UtilesResources.getProperty(UtilesResources.PROP_WS_ENDPOINT_VALIDACION));
            ValidarDoc servicio = new ValidarDoc( wsdllocation );
            portvalida = servicio.getValidarDocHttpSoap12Endpoint();
            BindingProvider bindingProvider = (BindingProvider) portvalida; 
            bindingProvider.getRequestContext().put( BindingProvider.ENDPOINT_ADDRESS_PROPERTY, UtilesResources.getProperty(UtilesResources.PROP_WS_ENDPOINT_VALIDACION) );
        }
        return portvalida;        
    }
    
    public static WSFirmaDocPortType getInstancePortWS() throws IOException{
        if (port == null){
            URL wsdllocation = new URL(UtilesResources.getProperty(UtilesResources.PROP_WS_ENDPOINT));
            WSFirmaDoc servicio = new WSFirmaDoc( wsdllocation );
            port = servicio.getWSFirmaDocHttpSoap12Endpoint();
            BindingProvider bindingProvider = (BindingProvider) port; 
            bindingProvider.getRequestContext().put( BindingProvider.ENDPOINT_ADDRESS_PROPERTY, UtilesResources.getProperty(UtilesResources.PROP_WS_ENDPOINT) );
        }
        return port;
    }
    
}
