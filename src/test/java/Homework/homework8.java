package Homework;

import base_urls.homework9Baseurl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class homework8 extends homework9Baseurl {
     /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */
    @Test
    public  void homework8() {
        spec.pathParams("users", "");
        //Set the expected data(Payload) --> Prepare it as Map
        Map<String, String> expectedData = new HashMap<>();
        expectedData.put("name", "morpheus");
        expectedData.put("job", "leader");
        System.out.println("expectedData = " + expectedData);
        Response response = given(spec).body(expectedData).post("{users}");
        response.prettyPrint();
        response
                .then()
                .statusCode(201)
                .body("name", equalTo(("morpheus")),
                        "job", equalTo(("leader")));


    }
}
