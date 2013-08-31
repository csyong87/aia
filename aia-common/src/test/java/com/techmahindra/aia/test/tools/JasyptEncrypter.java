package com.techmahindra.aia.test.tools;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class JasyptEncrypter {

    public static void main(String... args) {
        StandardPBEStringEncryptor e = new StandardPBEStringEncryptor();
        e.setAlgorithm("PBEWithMD5AndTripleDES");
        e.setPassword("0xDEADBEEF");
        System.out.println(e.encrypt("password"));
    }
}
