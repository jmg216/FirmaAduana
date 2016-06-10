package com.isa.firma.xades;

import java.security.PrivateKey;
import java.security.cert.Certificate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JMiraballes
 */
public class XMLFirma {

    private PrivateKey pk;
    private Certificate[] chainCert;
    private String providername;
    private String dn;
    private String firmante;
    private String nroSerie;
    
    

    public PrivateKey getPk() {
        return pk;
    }

    public void setPk(PrivateKey pk) {
        this.pk = pk;
    }

    public Certificate[] getChainCert() {
        return chainCert;
    }

    public void setChainCert(Certificate[] chainCert) {
        this.chainCert = chainCert;
    }

    public String getProvidername() {
        return providername;
    }

    public void setProvidername(String providername) {
        this.providername = providername;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public String getFirmante() {
        return firmante;
    }

    public void setFirmante(String firmante) {
        this.firmante = firmante;
    }

    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }    
    
}
