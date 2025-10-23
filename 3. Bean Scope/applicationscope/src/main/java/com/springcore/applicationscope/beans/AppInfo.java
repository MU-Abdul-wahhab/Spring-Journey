package com.springcore.applicationscope.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class AppInfo {
    private final String AppName = "ApplicationScope Demo Application";
    private final double AppVersion = 1.0;

    public AppInfo() {
        System.out.println("A New AppInfo Bean Created (Application Scope)");
    }

    public double getAppVersion() {
        return AppVersion;
    }

    public String getAppName() {
        return AppName;
    }
}
