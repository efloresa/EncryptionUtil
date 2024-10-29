/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.gob.ec.encryptionutil;

/**
 *
 * @author erik.flores
 */
public class KeyGeneratorMain {
    
    public static void main(String[] args) {
        try {
            // Generar y almacenar la clave de encriptación
            KeyManager.generateAndStoreKey();
            System.out.println("Clave de encriptación generada y almacenada con éxito.");
        } catch (Exception e) {
            System.err.println("Error al generar la clave de encriptación: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
