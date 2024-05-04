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

public class postuser {

@Test
    public static void createUser() {
    String url = "https://petstore.swagger.io/v2";
        String strJson = """
            {
                "id": 0,
                "username": "bushraa16",
                "firstName": "bushraa",
                "lastName": "alharbi",
                "email": "booshraa1666@hotmail.com",
                "password": "Aa123456",
                "phone": "966507876821",
                "userStatus": 0
            }
            """;
    userpojo expectedData = convertJsonToJava(strJson, userpojo.class);
    System.out.println("expectedData = " + expectedData);
        Response response = given()
                .contentType(ContentType.JSON)
                .body(expectedData)
                .post(url + "/user");
    response.then().statusCode(200).body("type",equalTo("unknown"));
    }
}