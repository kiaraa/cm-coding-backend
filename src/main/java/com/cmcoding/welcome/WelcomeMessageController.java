package com.cmcoding.welcome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeMessageController {

    @GetMapping("/welcome-message")
    public String getWelcomeMessage() {
        System.out.println("Got a welcome-message request.");
        return "Hi Corliss - we have a website up finally.  Look for future changes to come a little faster now!";
    }
}
