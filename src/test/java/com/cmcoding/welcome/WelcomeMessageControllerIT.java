package com.cmcoding.welcome;

import com.cmcoding.CmCodingBackendApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CmCodingBackendApplication.class)
public class WelcomeMessageControllerIT {

    @LocalServerPort
    private int port;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:" + port + "/welcome-message",  String.class);
        assertThat(response).contains("Welcome to the CM-Coding course online companion app.");
    }

}
