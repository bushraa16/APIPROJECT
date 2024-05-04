package request;

import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPojo;

import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C24_ObjectMapperPostpojo extends JsonPlaceHolderBaseUrl {
    /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
               "userId": 55,
               "title": "Tidy your room",
               "completed": false
               }


            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
*/
    @Test
    public void test() throws JsonProcessingException {
        //set the url
        spec.pathParam("first","todos");
        String strjso= """
                {
                "userId": 55,
                "title": "Tidy your room",
                 "completed": false,
                  "id": 201
                }
                """;
        JsonPlaceHolderPojo expectedData = new ObjectMapper().readValue(strjso, JsonPlaceHolderPojo.class);//This readValue method works with two parameters. First one is String formatted Json, second one is the data type you want to convert the json to.
        System.out.println("expectedData = " + expectedData);
        Response response=given(spec).body(expectedData).post("{first}");
        response.prettyPrint();
        //Do assertion
      JsonPlaceHolderPojo actualData = new ObjectMapper().readValue(strjso, JsonPlaceHolderPojo.class);//This readValue method works with two parameters. First one is String formatted Json, second one is the data type you want to convert the json to.
        System.out.println("actualData = " + actualData);
        assert response.statusCode()==201;
        assert actualData.getUserId()==expectedData.getUserId();
        assert actualData.getCompleted()==expectedData.getCompleted();
        assert Objects.equals(actualData.getTitle(), expectedData.getTitle()) : "title did not match";
//another way
        response.then().statusCode(201)
                .body( "userId", equalTo(expectedData.getUserId()),
                        "title", equalTo(expectedData.getTitle()),
                        "completed", equalTo(expectedData.getCompleted())
                );
    }
}
