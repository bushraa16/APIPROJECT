package request;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
public class Task2 {
/*
    Given
        https://restful-booker.herokuapp.com/booking
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
        public void asserHeaderMethod(){
//        https://restful-booker.herokuapp.com/booking
//        User sends a GET Request to the url
            Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
            response.prettyPrint();

//        HTTP Status Code should be 200
            // Direct assertion can be performed with the then() method.
            response.then().statusCode(200);

//        Content Type should be JSON
            response.then().contentType("application/json");

//        Status Line should be HTTP/1.1 200 OK
            response.then().statusLine("HTTP/1.1 200 OK");



        }
    }

