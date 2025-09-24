package com.spring.journey.main;

import com.spring.journey.config.Config;
import com.spring.journey.beans.Car;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(Config.class);

        Supplier<Car> toyota = () -> {
            Car car = new Car();
            car.setBrand("Toyota");
            car.setModel("Supra");
            return car;
        };

        Car honda = new Car();
        honda.setBrand("honda");
        honda.setModel("Civic");

        Supplier<Car> hondaCar = () -> honda;

        context.registerBean("toyota" , Car.class , toyota);
        context.registerBean("honda" , Car.class , hondaCar);

        String userInput = "benz";

        try {
            Car car = context.getBean(userInput , Car.class);
            System.out.println("Getting Car Brand From Spring Context " +car.getBrand());
            System.out.println("Getting Car Model From Spring Context " +car.getModel());
        }catch (NoSuchBeanDefinitionException e) {
            System.out.println("Spring Context Does not have a bean called " + userInput);
        }

    }
}