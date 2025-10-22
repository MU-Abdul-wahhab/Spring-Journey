package com.springcore.singleton.Beans;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class EmailService {
    private String EmailServiceProvider = "Amazon SES";

    public String getEmailServiceProvider() {
        return EmailServiceProvider;
    }
}
