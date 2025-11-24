package org.example;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        String text = "Hello Word!";
        System.out.println("Criptografando...");

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);

        SecretKey secretKey = keyGenerator.generateKey();
        String encryptedText = encrypt(text, secretKey);
        System.out.println("Encrypted text: "+encryptedText);

        String decryptedText = decrypt(encryptedText, secretKey);
        System.out.println("Decrypted text: " + decryptedText);

    }

    public static String encrypt(String text, SecretKey key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] textByte = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(textByte);
    }

    public static String decrypt(String text, SecretKey key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] cryptoByte = Base64.getDecoder().decode(text.getBytes());
        byte[] textByte = cipher.doFinal(cryptoByte);
        return new String(textByte);
    }

}