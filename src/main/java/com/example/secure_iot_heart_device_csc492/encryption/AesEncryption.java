package com.example.secure_iot_heart_device_csc492.encryption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
@Service

public class AesEncryption {

    @Value("${aes.secret.key}")
    private String key;
    @Value("${aes.secret.iv}")
    private String iv;

    public String encrypt(String plainText) throws Exception {
        Cipher cipher = buildCipher (Cipher.ENCRYPT_MODE);
        byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String encryptedText) throws Exception {
        Cipher cipher = buildCipher(Cipher.DECRYPT_MODE);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decrypted, StandardCharsets.UTF_8);
    }

    private Cipher buildCipher(int mode) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        cipher.init(mode, secretKeySpec, ivParameterSpec);
        return cipher;
    }


}
