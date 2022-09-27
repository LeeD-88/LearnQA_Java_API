import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeWork {

    @Test
    public void testGetCookie(){

        Response responseGetHeaders = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();

        Headers headers = responseGetHeaders.getHeaders();

        assertEquals(200, responseGetHeaders.statusCode(), "Unexpected status code");
        assertTrue(headers.hasHeaderWithName("x-secret-homework-header"), "Response doesn't have 'x-secret-homework-header' header");

    }
}
