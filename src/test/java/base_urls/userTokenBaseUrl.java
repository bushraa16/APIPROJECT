package base_urls;

import Homework.homework15.AddUser;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class userTokenBaseUrl {
    // We avoid repetitive tasks when sending requests with the RequestSpecification object.
    // For example: repetitive tasks such as base URL and headers.

    protected RequestSpecification spec; // This is null in this line, setUp() method should run before using this.

    @BeforeMethod // Runs before each @Test
    public void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")
                .addHeader("Authorization", "Bearer " + AddUser.token)// generateToken() method will create a fresh token for each run.
                .setContentType(ContentType.JSON)
                .build();
        // We don't need to add all these in each request. Just once we add them in spec object and they will be added when we use spec object.
    }

    // Example test method using the spec object
//    public void exampleTest() {
//        Response response = given().spec(spec)
//                .get("/users");
//        // Handle the response
//        // ...
//    }
}