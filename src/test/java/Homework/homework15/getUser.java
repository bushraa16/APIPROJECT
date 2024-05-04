package Homework.homework15;

import base_urls.userTokenBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class getUser extends userTokenBaseUrl {
    /*
       Given
          https://thinking-tester-contact-list.herokuapp.com/users/me
       When
           Send GET request to the url
       Then
           Assert that status code is 200
       And
           Response body should first name and lastname and email and __v the same

        */
    @BeforeMethod
    public void setUp() {
        super.setUp(); // Call the setUp() method from the base class
    }

    @Test
    void getUsersTest(){
        //set the url
        spec.pathParams("first","users","second","me");
        //set the expected data
        //we don't have any specific body to assert
        //send the request and get the response
        Response response=given(spec).get("{first}/{second}");
        response.prettyPrint();
        //Do assertion
//        response.then().statusCode(200);

    }
}
