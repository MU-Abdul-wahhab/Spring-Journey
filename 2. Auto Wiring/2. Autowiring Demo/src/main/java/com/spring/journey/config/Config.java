package com.spring.journey.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.spring.journey.beans",
        "com.spring.journey.implementation",
        "com.spring.journey.services"
})
public class Config {
}
