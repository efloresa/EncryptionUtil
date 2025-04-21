/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.gob.ec.encryptionutil;

import java.io.FileInputStream;
import java.io.InputStream;

import java.util.Properties;

import javax.crypto.SecretKey;

/**
 *
 * @author erik.flores
 */
public class DecryptCredentials {
    
    static String strDirectorioSistema = KeyManager.getDirectorioSistema() + "/resources/";
    
    public static void main(String[] args) {
        try {
            SecretKey key = KeyManager.loadKey();
            Properties props = new Properties();

            try (InputStream input = new FileInputStream(strDirectorioSistema + "config.properties")) {
                props.load(input);
            }

            String encryptedUsername = props.getProperty("DB.USER");
            String encryptedPassword = props.getProperty("DB.PASSWD");

            String username = KeyManager.decrypt(encryptedUsername, key);
            String password = KeyManager.decrypt(encryptedPassword, key);

            System.out.println("Usuario: " + username);
            System.out.println("Contraseña: " + password);

            // Ahora puedes usar el usuario y contraseña para conectarte a la base de datos
        } catch (Exception e) {
            System.err.println("Error en la desencriptación de las credenciales: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
