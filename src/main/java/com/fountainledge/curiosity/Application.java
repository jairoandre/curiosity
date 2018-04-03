package com.fountainledge.curiosity;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        
        try {
            SSLUtil.turnOffSslChecking();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        SpringApplication.run(Application.class, args);
    }
    
}