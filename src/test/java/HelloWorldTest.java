import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HelloWorldTest{

    @Test
    public void testRestAssured(){

        JsonPath response = RestAssured
                .get(" https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();

        ArrayList answer = (ArrayList) response.getList ("messages");
        System.out.println(answer.get(1));
    }

}

