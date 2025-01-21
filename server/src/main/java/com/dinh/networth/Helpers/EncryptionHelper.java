package com.dinh.networth.Helpers;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class EncryptionHelper {
    private static final String ALGORITHM= "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    @Value("${encryption.aes.key}")
    private static String key;
    private static SecretKey aesKey;

    // Lazy Evaluation
    private static SecretKey getAESKey() {
        if (aesKey != null) {
            return aesKey;
        }
        byte[] decodedKey= Decoders.BASE64.decode(key);
        aesKey= new SecretKeySpec(decodedKey, 0, decodedKey.length, ALGORITHM);
        return aesKey;
    }

    public static String encrypt(String data) throws Exception {
        Cipher cipher= Cipher.getInstance(TRANSFORMATION);

        // Generate an Initialization Vector
        byte[] iv= new byte[16];
        new SecureRandom().nextBytes(iv);
        IvParameterSpec ivSpec= new IvParameterSpec(iv);

        cipher.init(Cipher.ENCRYPT_MODE, getAESKey(), ivSpec);
        byte[] cipherBytes= cipher.doFinal(data.getBytes());

        byte[] encryptedBytes= new byte[iv.length + cipherBytes.length];

        // Prepend iv to be able to extract it later
        System.arraycopy(iv, 0, encryptedBytes, 0, iv.length);
        System.arraycopy(cipherBytes, 0, encryptedBytes, iv.length, cipherBytes.length);

        return Encoders.BASE64.encode(encryptedBytes);
    }

    public static String decrypt(String encryptedData) throws Exception {
        Cipher cipher= Cipher.getInstance(TRANSFORMATION);

        // Get iv and encrypted data in byte form
        byte[] ivAndEncryptedDataBytes= Decoders.BASE64.decode(encryptedData);

        // Get IV
        byte[] extractedIv= new byte[16];
        System.arraycopy(ivAndEncryptedDataBytes, 0, extractedIv, 0, extractedIv.length);
        IvParameterSpec ivSpec= new IvParameterSpec(extractedIv);

        // Get encryptedBytes
        byte[] encryptedBytes= new byte[ivAndEncryptedDataBytes.length - extractedIv.length];
        System.arraycopy(ivAndEncryptedDataBytes, extractedIv.length, encryptedBytes, 0, encryptedBytes.length);

        cipher.init(Cipher.DECRYPT_MODE, getAESKey(), ivSpec);
        byte[] decryptedBytes= cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

}
