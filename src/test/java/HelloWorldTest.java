import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HelloWorldTest{

   @ParameterizedTest
   @ValueSource(strings = {"", "Nik", "NikName15symbol", "NikName16symbols"})
    public void testHelloMethodWithoutName(String nikName){
       Map<String, String> queryParams = new HashMap<>();
       if (nikName.length()>15){
           queryParams.put("nikName", nikName);
       }
        JsonPath response = RestAssured
                .given()
                .queryParam("nikName", nikName)
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();
        String answer = response.getString("answer");
        String expectedName = (nikName.length() <=15) ? nikName : "someone";
        assertEquals("Hello, " + expectedName, answer, "The answer is noe expected");

    }

}