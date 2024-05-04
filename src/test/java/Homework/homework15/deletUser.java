package Homework.homework15;
import base_urls.BookerBaseUrl;
import base_urls.userTokenBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class deletUser extends userTokenBaseUrl {
    /*
    Given
       https://thinking-tester-contact-list.herokuapp.com/users/me
    When
        Send DELETE request to the url
    Then
        Status code should be 200

     */

    @Test
    void deleteBookingTest(){
        //Set the url
        spec.pathParams("first", "users", "second", "me");
        //Set the expected data
        //Send the request and get the response
        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

    }
}