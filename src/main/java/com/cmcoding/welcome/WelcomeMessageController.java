package com.cmcoding.welcome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeMessageController {

    @GetMapping("/welcome-message")
    public String getWelcomeMessage() {
        System.out.println("Got a welcome-message request.");
        return "Welcome to the CM-Coding courseonline companion app.";
    }
}
