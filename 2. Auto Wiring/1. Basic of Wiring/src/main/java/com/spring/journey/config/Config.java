package com.spring.journey.config;

import com.spring.journey.beans.Phone;
import com.spring.journey.beans.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    Phone samsung(){
        Phone phone = new Phone();
        phone.setBrand("Samsung");
        phone.setModel("S24 Ultra");
        return phone;
    }

    @Bean
    User samsungUser(Phone phone){
        User user = new User();
        user.setName("Abdul");
        user.setPhone(phone);
        return user;
    }

}
