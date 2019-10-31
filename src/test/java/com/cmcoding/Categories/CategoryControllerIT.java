package com.cmcoding.Categories;

import com.cmcoding.CmCodingBackendApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

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
    public void testGetCategoryIdTips(){
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
    public void getTipById(){
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:" + port + "/categories/8/tips/49";
        String response = rt.getForObject(url, String.class);
        assertThat(response).isEqualToIgnoringWhitespace("{\n" +
                "      \"id\": 49,\n" +
                "      \"tip\": \"Lung Transplant- highlight the 3 stages Removal, Backbench work and Insertion.\",\n" +
                "      \"categoryId\": 8\n" +
                "    }");
    }
}
