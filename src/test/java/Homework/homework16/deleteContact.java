package Homework.homework16;

import base_urls.userTokenBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class deleteContact extends userTokenBaseUrl {
    @Test
    void deleteBookingTest(){
        spec.pathParams("first", "contacts");
        Response response = given(spec).delete("{first}");
        response.prettyPrint();
    }}
