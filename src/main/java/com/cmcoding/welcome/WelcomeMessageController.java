package com.cmcoding.welcome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeMessageController {

    @GetMapping("/welcome-message")
    public String getWelcomeMessage() {
        return "Welcome, people!";
    }
}
