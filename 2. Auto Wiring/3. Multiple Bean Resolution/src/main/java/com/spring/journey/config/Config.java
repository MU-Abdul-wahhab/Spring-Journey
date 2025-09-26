package com.spring.journey.config;

import com.spring.journey.beans.BackPanel;
import com.spring.journey.beans.Display;
import com.spring.journey.beans.OS;
import com.spring.journey.beans.Phone;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {

    @Bean("oled")
    Display oled() {
        Display oled = new Display();
        oled.setType("OLED");
        return oled;
    }

    @Bean("lcd")
    Display lcd() {
        Display oled = new Display();
        oled.setType("LCD");
        return oled;
    }

    @Bean
    Phone phone(Display oled, BackPanel panel , @Qualifier("14") OS os) {
        Phone phone = new Phone();
        phone.setDisplay(oled);
        phone.setBackPanel(panel);
        phone.setOs(os);
        return phone;
    }

    @Bean
    @Primary
    BackPanel panel1() {
        BackPanel panel1 = new BackPanel();
        panel1.setColour("Black");
        return panel1;
    }

    @Bean
    BackPanel panel2() {
        BackPanel panel2 = new BackPanel();
        panel2.setColour("Gray");
        return panel2;
    }

    @Bean("14")
    OS os1() {
        OS os1 = new OS();
        os1.setOS("Android 14");
        return os1;
    }

    @Bean("15")
    OS os2() {
        OS os2 = new OS();
        os2.setOS("Android 15");
        return os2;
    }

}
