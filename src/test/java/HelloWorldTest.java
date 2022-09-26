import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HelloWorldTest{

    @Test
    public void testRestAssured(){

        Response responseFirst = given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        responseFirst.prettyPrint();

       /*int statusCode = responseFirst.getStatusCode();
        String locationHeader = responseFirst.getHeader("Location");
        System.out.println(statusCode);
        System.out.println(locationHeader);*/

        int count=0;
        int statusCode = responseFirst.getStatusCode();
        String locationHeader = responseFirst.getHeader("Location");
        while (statusCode==301) {

            Response responseNext = given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get("nextAddress")
                    .andReturn();
            count++;
            if (statusCode==200){
                responseNext.prettyPrint();
            }
        }

    }
}