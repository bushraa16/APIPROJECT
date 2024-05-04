package Homework.homework13;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.userpojo;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class getuser {
    @Test
    public static void getUser() {
        String url= "https://petstore.swagger.io/v2";
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
                .get(url + "/user/bushraa16");
        userpojo actualdata = convertJsonToJava(response.asString(), userpojo.class);
        System.out.println("actualdata = " + actualdata);
        assertEquals(response.statusCode(), 200);
        assertEquals(actualdata.getUsername(), expectedData.getUsername());
        assertEquals(actualdata.getFirstName(), expectedData.getFirstName());
        assertEquals(actualdata.getLastName(), expectedData.getLastName());
        assertEquals(actualdata.getEmail(), expectedData.getEmail());
        assertEquals(actualdata.getPassword(), expectedData.getPassword());
        assertEquals(actualdata.getPhone(), expectedData.getPhone());
        assertEquals(actualdata.getUserStatus(), expectedData.getUserStatus());
    }

}