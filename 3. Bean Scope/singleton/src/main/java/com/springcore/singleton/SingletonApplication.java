package com.springcore.singleton;

import com.springcore.singleton.Beans.EmailService;
import com.springcore.singleton.config.config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SingletonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SingletonApplication.class, args);

        var context = new AnnotationConfigApplicationContext(config.class);

        EmailService emailService1 = context.getBean(EmailService.class);
        EmailService emailService2 = context.getBean(EmailService.class);

        if(emailService1 == emailService2){
            System.out.println("Email Service is already present in Singleton Application");
        }

    }

}
