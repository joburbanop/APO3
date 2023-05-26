/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mundo;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.ResourceBundle;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;


/**
 *
 * @author joburbanop
 */
public class Cifrado {
    /*-----------------------------------------------
    *Atributos
    *-------------------------------------------------*/
    private ResourceBundle env;
    private String clave;
    
    /*----------------------------
    *Metodos
    *----------------------------------------*/
    public Cifrado(){
        this.env=ResourceBundle.getBundle("emberoment");
        this.clave=env.getString("clave");   
    }
    
    
     private SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        
        byte[] claveEncriptar = clave.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        
        claveEncriptar = sha.digest(claveEncriptar);
        claveEncriptar = Arrays.copyOf(claveEncriptar,16);
        
        SecretKeySpec secretKey = new SecretKeySpec(claveEncriptar, "AES");
        
        return secretKey;
        
    }
     
     
    
    public String encriptar(String datos) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        SecretKeySpec secretKey = this.crearClave(this.clave);
        
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
        byte[] datosEncriptar = datos.getBytes("UTF-8");
        byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
        String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);
        
        return encriptado;
        
    }
    
  
}
