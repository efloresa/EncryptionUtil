/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.gob.ec.encryptionutil;

import java.io.FileOutputStream;
import java.io.OutputStream;

import java.util.Properties;

import javax.crypto.SecretKey;

/**
 *
 * @author erik.flores
 */
public class EncryptCredentials {

    
    public static void main(String[] args) {
        
        String strDirectorioSistema = KeyManager.getDirectorioSistema() + "/resources/";
        
        //String dbUser = "AAAAA";
        //String dbPass = "AAAA";
        
        //String mailFrom = "AAAA.axis@ADDDD.AAAAA.ec";
        //String mailPass = "FGFDG";
        
        //String dbUser = "JNT.SDF";
        //String dbPass = "";
        
        String dbUser = "AXISATM";
        String dbPass = "NSVDLMSVCE";
        
        String mailFrom = "notificaciones.axis@atm.gob.ec";
        String mailPass = "m6lifw4bmXLzkZp";
        
        try {
            SecretKey key = KeyManager.loadKey();
            String encryptedUsername1 = KeyManager.encrypt(dbUser, key);
            String encryptedPassword2 = KeyManager.encrypt(dbPass, key);

            String encryptedUsername3 = KeyManager.encrypt(mailFrom, key);
            String encryptedPassword4 = KeyManager.encrypt(mailPass, key);
            
            System.out.println("DB.PASSWD: " + encryptedPassword2);
            System.out.println("MAIL.PASS: " + encryptedPassword4);
            
            Properties props = new Properties();
            props.setProperty("DB.USER", encryptedUsername1);
            props.setProperty("DB.PASSWD", encryptedPassword2);
            //props.setProperty("otra.propiedad", "propiedad11");
            props.setProperty("MAIL.FROM", encryptedUsername3);
            props.setProperty("MAIL.PASS", encryptedPassword4);
            //props.setProperty("otra.propiedad", "propiedad11");

            try (OutputStream output = new FileOutputStream( strDirectorioSistema + "config.properties")) {
                props.store(output, null);
            }

            System.out.println("Credenciales encriptadas y almacenadas con éxito.");
        } catch (Exception e) {
            System.err.println("Error en la encriptación de las credenciales: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
