import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HelloWorldTest{

    @Test
    public void testRestAssured() throws InterruptedException {

        JsonPath responseForToken = RestAssured
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String responseToken = responseForToken.get("token");

        Map<String, String> params = new HashMap<>();
        params.put("token", responseToken);
        int timeToSleep = responseForToken.get("seconds");

        // Create a TimeUnit object
        TimeUnit time = TimeUnit.SECONDS;
        time.sleep(timeToSleep);

        Response responseWithToken = RestAssured

                .given()
                .queryParams(params)
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .andReturn();
        responseWithToken.print();

    }
}