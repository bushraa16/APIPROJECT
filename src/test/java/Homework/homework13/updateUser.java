package Homework.homework13;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.userpojo;

import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class updateUser {
    @Test
    public static void updateUser() {
        String url = "https://petstore.swagger.io/v2";
        String strJson = """
            {
                "id": 0,
                "username": "bushraa16",
                "firstName": "bushraa",
                "lastName": "alharbi",
                "email": "booshraa1666@hotmail.com",
                "password": "Aa123456Aa@",
                "phone": "966507876821",
                "userStatus": 0
            }
            """;
        Map expectedData = convertJsonToJava(strJson, Map.class);
        System.out.println("expectedData = " + expectedData);
        Response response = given()
                .contentType(ContentType.JSON)
                .body(expectedData)
                .put(url + "/user/bushraa16");
        response.then().statusCode(200).body("type",equalTo("unknown"));

    }
}