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
        //String username = "notificaciones.plavit@atm.gob.ec";
        //String password = "Nt#EPmtg!!hf92";
        
        String username = "notificaciones.axis@atm.gob.ec";
        String password = "Epmtg***2845#";
        
        try {
            SecretKey key = KeyManager.loadKey();
            String encryptedUsername = KeyManager.encrypt(username, key);
            String encryptedPassword = KeyManager.encrypt(password, key);

            Properties props = new Properties();
            props.setProperty("db.username", encryptedUsername);
            props.setProperty("db.password", encryptedPassword);
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
