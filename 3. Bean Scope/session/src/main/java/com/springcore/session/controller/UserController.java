package com.springcore.session.controller;

import com.springcore.session.beans.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserSession userSession;

    @Autowired
    public UserController(UserSession userSession) {
        this.userSession = userSession;
    }

    @GetMapping("/login")
    public String login(@RequestParam String username) {
        userSession.setName(username);
        return "Welcome, " + userSession.getName() + "!";
    }

    @GetMapping("/whoami")
    public String whoAmI() {
        return "Current User: " + (userSession.getName() != null ? userSession.getName() : "Guest");
    }

}
