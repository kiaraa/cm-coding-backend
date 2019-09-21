package com.cmcoding.welcome;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class WelcomeMessageControllerTest {
    @Test
    public void welcomeReturnsCorrectMessage() {
        WelcomeMessageController welcomeMessageController = new WelcomeMessageController();
        String welcome = welcomeMessageController.getWelcomeMessage();
        assertThat(welcome).isEqualTo("Welcome!");
    }
}