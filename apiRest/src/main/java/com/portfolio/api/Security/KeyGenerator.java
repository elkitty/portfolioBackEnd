package com.portfolio.api.Security;

import java.security.SecureRandom;
import java.util.Base64;

public class KeyGenerator {

     public String generateSecretKey(int length) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[length];
        secureRandom.nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }
}
