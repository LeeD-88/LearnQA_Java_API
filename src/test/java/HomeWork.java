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

        Response responseGetCookie = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();

        Map<String, String> cookies = responseGetCookie.getCookies();

        assertEquals(200, responseGetCookie.statusCode(), "Unexpected status code");
        assertTrue(cookies.containsKey("HomeWork"), "Response doesn't have 'HomeWork' cookie");

    }
}
