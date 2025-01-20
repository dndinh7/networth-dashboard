package com.dinh.networth.Helpers;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

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

    public static String encrypt(String data, byte[] iv) throws Exception {
        Cipher cipher= Cipher.getInstance(TRANSFORMATION);

        cipher.init(Cipher.ENCRYPT_MODE, getAESKey(), new IvParameterSpec(iv));
        byte[] encryptedBytes= cipher.doFinal(data.getBytes());
        return Encoders.BASE64.encode(encryptedBytes);
    }

    public static String decrypt(String encryptedData, byte[] iv) throws Exception {
        Cipher cipher= Cipher.getInstance(TRANSFORMATION);

        cipher.init(Cipher.DECRYPT_MODE, getAESKey(), new IvParameterSpec(iv));
        byte[] decodedBytes= Decoders.BASE64.decode(encryptedData);
        byte[] decryptedBytes= cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

}
