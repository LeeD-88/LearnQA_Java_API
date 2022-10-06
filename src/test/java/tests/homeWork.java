package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;


public class homeWork {

    @Test
    public void testRestAssured() throws IOException {

        Response responseFirstRedrect = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        int statusCode = responseFirstRedrect.getStatusCode();
        System.out.println(statusCode);
        String url = responseFirstRedrect.getHeader("Location");
        System.out.println(url);

        URL obj = new URL(url);
        Response responseSecondRedrect = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(obj)
                    .andReturn();

        statusCode = responseSecondRedrect.getStatusCode();
        System.out.println(statusCode);
        String url2 = responseSecondRedrect.getHeader("Location");
        System.out.println(url2);

        obj = new URL(url2);
        Response responseThirdRedrect = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get(obj)
                .andReturn();

        statusCode = responseThirdRedrect.getStatusCode();
        System.out.println(statusCode);
        String url3 = responseThirdRedrect.getHeader("Location");
        System.out.println(url3);

        obj = new URL(url3);
        Response responseFourthRedrect = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get(obj)
                .andReturn();

        statusCode = responseFourthRedrect.getStatusCode();
        System.out.println(statusCode);
        String url4 = responseFourthRedrect.getHeader("Location");
        System.out.println(url4);
    }
}