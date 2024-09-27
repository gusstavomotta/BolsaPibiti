/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gustavo Motta
 */
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;

public class CriptografaDados {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
    private static final String CHAVE = "1234567890123456";

    public static String criptografar(String senha) throws Exception {

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKeySpec secretKey = new SecretKeySpec(CHAVE.getBytes(), ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] senhaCriptografada = cipher.doFinal(senha.getBytes());
        return Base64.getEncoder().encodeToString(senhaCriptografada);
    }

    public static String descriptografar(String senhaCriptografada) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKeySpec secretKey = new SecretKeySpec(CHAVE.getBytes(), ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] senhaDecodificada = Base64.getDecoder().decode(senhaCriptografada);
        byte[] senhaDescriptografada = cipher.doFinal(senhaDecodificada);
        return new String(senhaDescriptografada);
    }


}
