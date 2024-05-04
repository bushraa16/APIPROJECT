package Homework.homework15;
import base_urls.userTokenBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.BookingPojo;
import pojos.UserInformationPojo;
import utilities.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static utilities.ObjectMapperUtils.convertJsonToJava;
public class AddUser extends userTokenBaseUrl {
      /*
    Given
        https://thinking-tester-contact-list.herokuapp.com/users
    And
    {
     "firstName": "Test",
    "lastName": "User",
    "email": "test@fake.com",
    "password": "myPassword"
    }
    When
        Send POST request to the url
    Then
        Status code should be 200
    And
        Response body should be like:
    "user": {
        "_id": "",random
        "firstName": "bushraa",
        "lastName": "alharbi",
        "email": "bushratester@hotmail.com",
        "__v": 1
    },
    "token": "" random

     */
    public static String token;

    @Test
    public void AddUserTest(){
        //Set the url
        spec.pathParams("first","users");

        //Set the expected data
        String strJson= """
                {
                             "firstName": "bushraa",
                             "lastName": "alharbi",
                             "email": "bushraalhadsrbitester@hotmail.com",
                             "password":"Aa1234567"
                  
                         }
                """;

        UserInformationPojo expectedData =ObjectMapperUtils.convertJsonToJava(strJson, UserInformationPojo.class);
        System.out.println(expectedData);
        Response response=given(spec).body(expectedData).post("{first}");
        response.prettyPrint();
        token = response.jsonPath().getString("token");
        response
                .then()
                .assertThat()
                .statusCode(201)
                .body("user.firstName", equalTo(expectedData.getFirstName()),
                        "user.lastName",equalTo(expectedData.getLastName()),
                        "user.email",equalTo(expectedData.getEmail()),
                       "user.__v",equalTo(1));



    }

}
