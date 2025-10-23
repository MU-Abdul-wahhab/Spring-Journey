package com.springcore.applicationscope.controller;

import com.springcore.applicationscope.beans.AppInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final AppInfo appInfo;

    @Autowired
    public TestController(AppInfo appInfo) {
        this.appInfo = appInfo;
    }

    @GetMapping("/app-name")
    public String getAppName() {
            return  appInfo.getAppName();
    }

    @GetMapping("/app-version")
    public double getAppVersion() {
        return appInfo.getAppVersion();
    }
}
