package Homework.homework15;
import base_urls.userTokenBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PutchUser extends userTokenBaseUrl {

/*
    Given
       https://thinking-tester-contact-list.herokuapp.com/users/me
    And
        {
            "firstName": "bushra1",
                             "lastName": "alharbi",
                             "email": "bushratester@hotmail.com",
                             "password":"Aa1234567"
                             }
    When
        Send PATCH request to the url
    Then
        Status code should be 200
    And
        "user": {
        "_id": "",random
        "firstName": "bushra1",
        "lastName": "alharbi",
        "email": "bushraaQatester@hotmail.com",
        "__v": 1
    },

     */



        @Test
        void partialUpdateBookingTest(){
            //Set the url
            spec.pathParams("first", "users", "second", "me");

            //Set the expected Data
            String strJson= """
                {
                             "firstName": "bushra1",
                             "lastName": "alharbi",
                             "email": "bushraalharbitester@hotmail.com",
                             "password":"Aa1234567"
                  
                         }
                """;
            Map expectedData = ObjectMapperUtils.convertJsonToJava(strJson, Map.class);//In patch request Map payload is recommended.
            System.out.println("expectedData = " + expectedData);
            //Send the request and get the response
            Response response = given(spec).body(expectedData).patch("{first}/{second}");
            response.prettyPrint();
            //Do assertion
            Map actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), Map.class);
            System.out.println("actualData = " + actualData);
            assertEquals(response.statusCode(), 200);
            assertEquals(actualData.get("user.firstname"), expectedData.get("user.firstname"));
            assertEquals(actualData.get("user.lastname"), expectedData.get("user.lastname"));
            assertEquals(actualData.get("user.email"), expectedData.get("user.email"));
            assertEquals(actualData.get("user.password"), expectedData.get("user.password"));
            //...
        }

    }
