package com.techmahindra.aia.tools;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class PasswordEncoder {

    public static void main(String... args) {
        ShaPasswordEncoder pe = new ShaPasswordEncoder(256);
        pe.setIterations(1024);
        System.out.println(pe.encodePassword("password", "christian"));

    }
}
