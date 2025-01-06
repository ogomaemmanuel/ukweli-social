package com.ogoma.blog.security;

import com.ogoma.blog.config.AppProperties;
import com.ogoma.blog.config.AppPropertiesHolder;
import jakarta.persistence.Entity;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.util.StringUtils;


public class PIIEncryptor {

    public String encrypt(String plaintext) {
        if (!StringUtils.hasLength(plaintext))
            return plaintext;
        var appProperties = AppPropertiesHolder.getAppProperties();
        String salt = KeyGenerators.string().generateKey();
        TextEncryptor textEncryptor = Encryptors.delux(appProperties.getSymmetricEncryptionSecret(), salt);
        return String.format("%s:%s", salt, textEncryptor.encrypt(plaintext));
    }

    public String decrypt(String cipherText) {
        if (!StringUtils.hasLength(cipherText))
            return cipherText;
        var appProperties = AppPropertiesHolder.getAppProperties();
        String salt = cipherText.split(":")[0];
        String encryptedPart = cipherText.split(":")[1];
        TextEncryptor textEncryptor = Encryptors.delux(appProperties.getSymmetricEncryptionSecret(), salt);
        return textEncryptor.decrypt(encryptedPart);
    }
}
