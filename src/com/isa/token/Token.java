package com.isa.token;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.isa.exception.AppletException;
import com.isa.utiles.Utiles;
import com.isa.utiles.UtilesMsg;
import com.isa.utiles.UtilesResources;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.ProviderException;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginException;
import sun.security.pkcs11.SunPKCS11;

/**
 *
 * @author JMiraballes
 */
public class Token {
    
    private String module;
    private String library;
    private Boolean showInfo;
    private String password;
    private Boolean activo;
    private KeyStore keystore;
    private String pkcs11config;
    private boolean logued;
    private ArrayList<X509Certificate> listaCerts;

    public Token(String module, String library, String password) throws IOException, KeyStoreException, NoSuchAlgorithmException, CertificateException {
        this.module = module;
        this.library = library;
        this.showInfo = true;
        this.password = password;
        this.listaCerts = new ArrayList();
    }
    
    
    public Token(String module, String library) throws AppletException  {
        
        this.module = module;
        this.library = library;
        this.showInfo = true;
        this.listaCerts = new ArrayList();
            
        try {    
            cargarConfiguracionInit();
        }
        catch(ProviderException ex){
            Logger.getLogger(Token.class.getName()).log(Level.SEVERE, null, ex);
            activo = false;
        }
        catch(KeyStoreException ex){
            Logger.getLogger(Token.class.getName()).log(Level.SEVERE, null, ex);
            activo = false;    
        }  
        catch (IOException ex){
            Logger.getLogger(Token.class.getName()).log(Level.SEVERE, null, ex);
            throw new AppletException(ex.getMessage(), null, ex.getCause());
        }
        catch(Exception ex){
            Logger.getLogger(Token.class.getName()).log(Level.SEVERE, null, ex);
            activo = false;    
        }
    }   
    
    private void cargarConfiguracionInit() throws AppletException, KeyStoreException, IOException{

        System.out.println("Token::cargarConfiguracionInit");

        pkcs11config = Utiles.setKeyValue(UtilesResources.getProperty("appletConfig.paramName"), module);
        pkcs11config += Utiles.setKeyValue(UtilesResources.getProperty("appletConfig.paramLibrary"), library);
        pkcs11config += Utiles.setKeyValue(UtilesResources.getProperty("appletConfig.paramShowInfo"), showInfo.toString());
        System.out.println("Config pkcs11: " + pkcs11config);            
        ByteArrayInputStream confStream = new ByteArrayInputStream(pkcs11config.getBytes());
        Provider prov = new sun.security.pkcs11.SunPKCS11( confStream );
        activo = true;
    }
    
    private void instanciarKeyStore() throws KeyStoreException{
        System.out.println("Token::instanciarKeyStore");
        ByteArrayInputStream confStream = new ByteArrayInputStream(pkcs11config.getBytes());
        Provider prov = new sun.security.pkcs11.SunPKCS11( confStream );
        Security.addProvider( prov );
        keystore = KeyStore.getInstance("PKCS11");
    }    
    
    
    //Operaciones
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getLibrary() {
        return library;
    }

    public void setLibrary(String library) {
        this.library = library;
    }

    public boolean isShowInfo() {
        return showInfo;
    }

    public void setShowInfo(boolean showInfo) {
        this.showInfo = showInfo;
    }

    public Boolean getShowInfo() {
        return showInfo;
    }

    public void setShowInfo(Boolean showInfo) {
        this.showInfo = showInfo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }    

    public KeyStore getKeystore() {
        return keystore;
    }

    public void setKeystore(KeyStore keystore) {
        this.keystore = keystore;
    }    

    public ArrayList<X509Certificate> getListaCerts() {
        return listaCerts;
    }

    public void setListaCerts(ArrayList<X509Certificate> listaCerts) {
        this.listaCerts = listaCerts;
    }
    
    public String getPkcs11config() {
        return pkcs11config;
    }

    public void setPkcs11config(String pkcs11config) {
        this.pkcs11config = pkcs11config;
    }    
    
    public void obtenerCertificados() throws IOException, KeyStoreException, NoSuchAlgorithmException, CertificateException {
        
        if (isLogued()){
            Enumeration aliases = keystore.aliases();
            while (aliases.hasMoreElements()) {
                Object alias = aliases.nextElement();
                X509Certificate cert0 = (X509Certificate) keystore.getCertificate(alias.toString());
                System.out.println("Certificado: " + Utiles.getCN(cert0.getSubjectDN().getName()));
                System.out.println("Emisor: " + Utiles.getCN(cert0.getIssuerDN().getName()) );
                System.out.println("Fecha Validez : " + Utiles.DATE_FORMAT_MIN.format(cert0.getNotAfter()));
                listaCerts.add( cert0 );
            }
        }
    }
    
    public boolean isLogued(){
        return logued;
    }
    
    public void login( String password ) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException{        
        System.out.println("Token::login"); 
        instanciarKeyStore();
        this.password = password;
        KeyStore.PasswordProtection pp = new KeyStore.PasswordProtection( password.toCharArray() );
        keystore.load(null , pp.getPassword() );
        logued = true;
    }
    
    public void logout() throws LoginException{
        System.out.println("Token::logout");
        
        ((SunPKCS11) keystore.getProvider() ).logout();
        keystore.getProvider().clear();     
        password = null;        
        logued = false;        
    }
}
