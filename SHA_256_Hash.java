package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SHA_256_Hash {


    public static String getHashSHA256(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] byteData = md.digest();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < byteData.length; ++i) {
                sb.append(Integer.toString((byteData[i] & 255) + 256, 16).substring(1));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException var5) {
            Logger.getLogger("SHA-1").log(Level.SEVERE, (String)null, var5);
            return null;
        }
    }
}
