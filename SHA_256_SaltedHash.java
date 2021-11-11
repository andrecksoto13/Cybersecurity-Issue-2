package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SHA_256_SaltedHash {

    public static byte[] getSaltedHashSHA256(String password, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] byteData = md.digest(password.getBytes());

            md.reset();
            return byteData;

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger("SHA-256").log(Level.SEVERE, "SHA-256 Not Valid", ex);
            return null;
        }
    }
}