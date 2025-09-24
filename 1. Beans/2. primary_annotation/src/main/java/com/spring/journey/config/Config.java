package com.spring.journey.config;

import com.spring.journey.beans.Phone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {

    @Bean(value = "apple")
    Phone apple(){
        Phone phone = new Phone();
        phone.setBrand("Apple");
        phone.setModel("Apple 11");
        return phone;
    }

    @Primary
    @Bean(value = "samsung")
    Phone samsung(){
        Phone phone = new Phone();
        phone.setBrand("Samsung");
        phone.setModel("S20 Plus");
        return phone;
    }

}
