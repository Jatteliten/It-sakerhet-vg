package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        if(args.length == 0) {
            SpringApplication.run(Demo1Application.class, args);
        }else if(Objects.equals(args[0], "createhashes")){
            SpringApplication application = new SpringApplication(CreateHashes.class);
            application.setWebApplicationType(WebApplicationType.NONE);
            application.run(args);
        }
    }

}
