package Homework;
import base_urls.UserBaseurl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class homework9 extends UserBaseurl {
    /*
Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
*/
    @Test
    public void homework9(){
//      String url=("https://petstore.swagger.io");
        spec.pathParams("first","v2","second","user");
     //   spec.pathParam("Createuser","user");
        Map<String,Object> expectedCreateUser=new HashMap<>();
        expectedCreateUser.put("id",1000);
        expectedCreateUser.put("username","bushra16");
        expectedCreateUser.put("firstName","bushraa");
        expectedCreateUser.put("lastName","alharbi");
        expectedCreateUser.put("email","booshraa1666@hotmail.com");
        expectedCreateUser.put("password","Aa123456");
        expectedCreateUser.put("phone","966543543621");
        expectedCreateUser.put("userStatus",200);
        System.out.println("expectedCreateUser = " + expectedCreateUser);
        //Send the request and get the response
        Response response = given(spec).body(expectedCreateUser).post("{first}/{second}");
       // Response response = given(spec).body(expectedCreateUser).post("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(200)
                .body("message", equalTo(("1000")),"code",equalTo(200));//By map payload, we can get specific data from body. This is more dynamic.
    }

}
