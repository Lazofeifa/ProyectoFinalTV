
package com.proyectotv;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {
    public static void main(String[] args) {
        var codigo = new BCryptPasswordEncoder();
        System.out.println("Kevin (pass1): "+codigo.encode("pass1"));
        System.out.println("Victor (pass2): "+codigo.encode("pass2"));
        System.out.println("Daniel (pass3): "+codigo.encode("pass3"));
        
    }
}
