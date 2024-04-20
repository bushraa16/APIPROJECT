package Homework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class homework3 {
    /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */
    @Test
    public void succesufull(){
        String url="https://reqres.in/api/users/3";
  // Response response= RestAssured.get(url);
        Response response = given().get(url);
  response.prettyPrint();
  response.then().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");
}}
