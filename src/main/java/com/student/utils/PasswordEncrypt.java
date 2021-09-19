package com.student.utils;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public abstract class PasswordEncrypt {
    
    public static String encryptText(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] output = md.digest(password.getBytes());
            return Base64.encode(output);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        
    }



}
