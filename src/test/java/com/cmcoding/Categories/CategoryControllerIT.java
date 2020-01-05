package com.cmcoding.Categories;

import com.cmcoding.Categories.Tip.Tip;
import com.cmcoding.CmCodingBackendApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
//import static sun.text.normalizer.UTF16.valueOf;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CmCodingBackendApplication.class)
public class CategoryControllerIT {

    @LocalServerPort
    private int port;

    @Test
    public void testGetAllCategoriesReturnsGoodData() throws Exception {
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:" + port + "/categories";
        String response = rt.getForObject(url, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        TipCategory[] tipCategories = objectMapper.readValue(response, TipCategory[].class);
        assertThat(tipCategories.length).isEqualTo(19);
    }

    @Test
    public void testGetCategoryById() {
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:" + port + "/categories/8";
        String response = rt.getForObject(url, String.class);
        assertThat(response).isEqualToIgnoringWhitespace("{\n" +
                "  \"id\": 8,\n" +
                "  \"name\": \"Respitory and Hem/Lymph Systems, Mediastinum/Diaphragm\",\n" +
                "  \"tips\": [\n" +
                "    {\n" +
                "      \"id\": 48,\n" +
                "      \"tip\": \"Make sure to reread the ICD-10 guidelines for this chapter and give yourself a clue as to the diagnoses that have guidelines (by putting an asterisk or star next to them).\",\n" +
                "      \"categoryId\": 8\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 49,\n" +
                "      \"tip\": \"Lung Transplant- highlight the 3 stages Removal, Backbench work and Insertion.\",\n" +
                "      \"categoryId\": 8\n" +
                "    }\n" +
                "  ]\n" +
                "}");
    }

    @Test
    public void testGetCategoryIdTips() {
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:" + port + "/categories/8/tips";
        String response = rt.getForObject(url, String.class);
        assertThat(response).isEqualToIgnoringWhitespace("[\n" +
                "    {\n" +
                "      \"id\": 48,\n" +
                "      \"tip\": \"Make sure to reread the ICD-10 guidelines for this chapter and give yourself a clue as to the diagnoses that have guidelines (by putting an asterisk or star next to them).\",\n" +
                "      \"categoryId\": 8\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 49,\n" +
                "      \"tip\": \"Lung Transplant- highlight the 3 stages Removal, Backbench work and Insertion.\",\n" +
                "      \"categoryId\": 8\n" +
                "    }\n" +
                "  ]");
    }

    @Test
    public void getTipById() {
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:" + port + "/categories/8/tips/49";
        String response = rt.getForObject(url, String.class);
        assertThat(response).isEqualToIgnoringWhitespace("{\n" +
                "      \"id\": 49,\n" +
                "      \"tip\": \"Lung Transplant- highlight the 3 stages Removal, Backbench work and Insertion.\",\n" +
                "      \"categoryId\": 8\n" +
                "    }");
    }

    @Test
    public void editTipsById() {
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:" + port + "/categories/1/tips/1";

        String response = rt.postForObject(url, new Tip(1, "Eat so many fruits", 1), String.class);

        assertThat(response).isEqualToIgnoringWhitespace("{\n" +
                "  \"id\":1,\n" +
                "  \"tip\": \"Eat so many fruits\",\n" +
                "  \"categoryId\":1\n" +
                "}"
        );
    }

    @Test
    public void putTip() {
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:" + port + "/categories/2/tips";

        HttpEntity<Tip> tipHttpEntity = new HttpEntity<>(new Tip("Eat so many fruits", 2));
        ResponseEntity<Tip> response = rt.exchange(url, HttpMethod.PUT, tipHttpEntity, Tip.class, new HashMap<>());

        Tip responseBody = response.getBody();

        Tip returnedTip = rt.getForObject("http://localhost:" + port + "/categories/2/tips/" + responseBody.getId(), Tip.class);

        assertThat(returnedTip.getTip()).isEqualTo(responseBody.getTip());
        assertThat(returnedTip.getCategoryId()).isEqualTo(responseBody.getCategoryId());
        assertThat(responseBody.getId()).isNotNull();
    };
}
