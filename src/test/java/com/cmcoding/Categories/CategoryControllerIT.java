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
                "    \"name\" : \"General health\",\n" +
                "    \"tips\":[\n" +
                "      {\n" +
                "        \"id\": 1,\n" +
                "        \"tip\": \"Eat vegetables\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2,\n" +
                "        \"tip\": \"Eat fruits\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\":2,\n" +
                "    \"name\": \"Bones\",\n" +
                "    \"tips\":[\n" +
                "      {\n" +
                "        \"id\": 3,\n" +
                "        \"tip\": \"Drink milk\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 4,\n" +
                "        \"tip\": \"Don't break em!\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 5,\n" +
                "        \"tip\": \"Osteoperosis is a bitch\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]");
    }
}
