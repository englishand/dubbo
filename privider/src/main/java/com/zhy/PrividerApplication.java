package com.zhy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

/**
 * springboot默认情况下是自带了嵌入式容器spring-boot-starter-tomcat，如果需要构建war文件并进行部署时需要需改启动类，继承SpringBootServletInitializer,
 * 并重写configure方法，打成war包放到tomcat中启动即可。
 */
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
