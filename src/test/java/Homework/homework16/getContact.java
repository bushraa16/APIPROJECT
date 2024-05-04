package Homework.homework16;

import base_urls.userTokenBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getContact  extends userTokenBaseUrl {
        @Test
        void getContactTest(){
            //set the url
            spec.pathParams("first","contacts");
            //set the expected data
            //we don't have any specific body to assert
            //send the request and get the response
            Response response=given(spec).get("{first}");
            response.prettyPrint();
            //Do assertion
        response.then().statusCode(200);

        }
    }

