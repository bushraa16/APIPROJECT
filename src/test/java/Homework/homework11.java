package Homework;

import groovyjarjarantlr4.v4.runtime.atn.SemanticContext;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class homework11 {
    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();

*/
    @Test
    public void test(){
        String url=" https://automationexercise.com/api/productsList";
        Response response=given().get(url);
        response.jsonPath().prettyPrint();
        int count = response.jsonPath().getList("products.findAll { it.category.usertype.usertype == 'Women' }").size();
        Assert.assertEquals(count, 12, "he number of Women user type is 12");
    }



}
