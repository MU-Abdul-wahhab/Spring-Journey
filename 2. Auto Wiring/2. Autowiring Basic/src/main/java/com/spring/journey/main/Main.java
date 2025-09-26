package com.spring.journey.main;

import com.spring.journey.beans.Phone;
import com.spring.journey.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);

        Phone phone = context.getBean(Phone.class);
        System.out.println("Phone Brand "+phone.getBrand());
        System.out.println("Phone Model " +phone.getModel());

        // 1. Field Level Annotation
        System.out.println("Phone BackPanel Colour " +phone.getBackPanel().getColour());

        //2. Autowiring using setter
        System.out.println("Phone Display Type " +phone.getDisplay().getType());

        //3. Constructor level Injection - Recommended Approach
        System.out.println("Phone OS Version " +phone.getOs().getVersion());
    }
}