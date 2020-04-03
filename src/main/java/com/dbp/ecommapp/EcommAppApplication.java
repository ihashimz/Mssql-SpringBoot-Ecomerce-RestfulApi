package com.dbp.ecommapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.Collections;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EcommAppApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(EcommAppApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "3450"));
        app.run(args);
    }

}
