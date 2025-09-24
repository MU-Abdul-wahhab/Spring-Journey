package com.spring.journey.config;


import com.spring.journey.beans.Car;
import com.spring.journey.beans.Laptop;
import com.spring.journey.beans.Phone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    Phone phone() {
        Phone apple = new Phone();
        apple.setBrand("Apple");
        apple.setModel("Apple 11");
        return apple;
    }

    @Bean
    Laptop hp() {
        Laptop laptop = new Laptop();
        laptop.setBrand("HP");
        laptop.setModel("Elite book 840 G3");
        return laptop;
    }

    @Bean
    Laptop asus() {
        Laptop laptop = new Laptop();
        laptop.setBrand("Asus");
        laptop.setModel("Viva book");
        return laptop;
    }

    @Bean(value = "honda")
    Car honda() {
        Car car = new Car();
        car.setBrand("Honda");
        car.setModel("Civic");
        return car;
    }

    @Bean(value = "toyota")
    Car toyota() {
        Car car = new Car();
        car.setBrand("Toyota");
        car.setModel("Supra");
        return car;
    }

}
