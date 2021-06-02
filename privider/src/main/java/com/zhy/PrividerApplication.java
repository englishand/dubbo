package com.zhy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication
@ImportResource({"classpath:config/privider.xml"})
public class PrividerApplication extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(PrividerApplication.class,args);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return super.configure(builder);
        return builder.sources(PrividerApplication.class);
    }
}
