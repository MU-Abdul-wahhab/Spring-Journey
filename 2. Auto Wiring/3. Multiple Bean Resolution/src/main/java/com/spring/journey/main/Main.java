package com.spring.journey.main;

import com.spring.journey.beans.Phone;
import com.spring.journey.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);

        // 1. Spring can automatically match a constructor or field variable name to a bean name
        // when multiple beans of the same type exist.
        Phone phone = context.getBean(Phone.class);
        System.out.println("Phone Display Type " +phone.getDisplay().getType());

        //2. If mechanism one is failed then spring will look at @Primary Annotation
        System.out.println("Phone BackPanel Colour " + phone.getBackPanel().getColour());

        //3. If mechanism two is also failed then spring will look at @Qualifier Annotation
        System.out.println("Phone Android Version " + phone.getOs().getOS());
    }
}