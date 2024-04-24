package Homework;

import base_urls.homework9Baseurl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class homework10 extends homework9Baseurl {
    //Using the https://petstore.swagger.io/ document,
    // write an automation test that finds the number of "pets" with the status "available" and asserts that there are more than 100.
    @Test
    public void homework10(){
        String url ="https://petstore.swagger.io/v2/pet/findByStatus?status=available";
//spec.pathParams("first","v2","second","pet");
//        Response response = given(spec).get("pet/findByStatus?status=available");
        Response response=given().get(url);
         response.then().statusCode(200);
        int availablePetsCount = response.jsonPath().getList("").size();
       // Assert.assertTrue("There are not more than 100 available pets.", availablePetsCount > 100);
        Assert.assertTrue(availablePetsCount > 100,"Expected more than 100 available pets, but found: " + availablePetsCount);



    }}
