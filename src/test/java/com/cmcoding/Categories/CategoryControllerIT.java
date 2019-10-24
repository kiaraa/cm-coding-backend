package com.cmcoding.Categories;

import com.cmcoding.CmCodingBackendApplication;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

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
        Assertions.assertThat(response).isEqualToIgnoringWhitespace("[\n" +
                "  {\n" +
                "    \"id\" : 1,\n" +
                "    \"name\" : \"Bones\",\n" +
                "    \"tips\":[\n" +
                "      {\n" +
                "        \"id\": 1,\n" +
                "        \"tip\": \"Drink milk\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2,\n" +
                "        \"tip\": \"Don't break em!\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 3,\n" +
                "        \"tip\": \"Osteoperosis is a bitch\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\":2,\n" +
                "    \"name\": \"General Health\",\n" +
                "    \"tips\":[\n" +
                "      {\n" +
                "        \"id\": 4,\n" +
                "        \"tip\": \"Eat vegetables\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 5,\n" +
                "        \"tip\": \"Eat fruits\"\n" +
                "      }" +
                "    ]\n" +
                "  }\n" +
                "]");
    }

    @Test
    public void testGetCategoryById() {
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:" + port + "/categories/1";
        String response = rt.getForObject(url, String.class);
        Assertions.assertThat(response).isEqualToIgnoringWhitespace("{\n" +
                "  \"id\" : 1,\n" +
                "  \"name\" : \"Bones\",\n" +
                "  \"tips\":[\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"tip\": \"Drink milk\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"tip\": \"Don't break em!\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 3,\n" +
                "      \"tip\": \"Osteoperosis is a bitch\"\n" +
                "    }\n" +
                "  ]\n" +
                "}");
    }

    @Test
    public void testGetCategoryIdTips(){
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:" + port + "/categories/2/tips";
        String response = rt.getForObject(url, String.class);
        Assertions.assertThat(response).isEqualToIgnoringWhitespace("[\n" +
                "  {\n" +
                "    \"id\": 4,\n" +
                "    \"tip\": \"Eat vegetables\"\n" +
                "  },\n" +
                "  {\n" +
                "  \"id\": 5,\n" +
                "  \"tip\": \"Eat fruits\"\n" +
                "  }\n" +
                "]");
    }

    @Test
    public void getTipById(){
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:" + port + "/categories/2/tips/5";
        String response = rt.getForObject(url, String.class);
        Assertions.assertThat(response).isEqualToIgnoringWhitespace("{\n" +
                "  \"id\": 5,\n" +
                "  \"tip\": \"Eat fruits\"\n" +
                "}");
    }
}
