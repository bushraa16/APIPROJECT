package Homework;

import com.sun.source.tree.AssertTree;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class homework14 {
    /*
    Given
        https://dummy.restapiexample.com/api/v1/employees
    When
        User sends Get Request to the Url
    Then
        Status code is 200
    And
        There are 24 employees
    And
        "Tiger Nixon" and "Garrett Winters" are among the employees
    And
        The greatest age is 66
    And
        The name of the lowest age is "Tatyana Fitzpatrick"
    And
        Total salary of all employees is 6,644,770
 */
    @Test
    public void hw14(){
      //  Given https://dummy.restapiexample.com/api/v1/employees
        String url=" https://dummy.restapiexample.com";
      //  User sends Get Request to the Url
        Response response=given().get(url+"/api/v1"+"/employees");
        response.then().statusCode(200)
                .body("data.id",hasSize(24),
                        "data.employee_name",hasItems("Tiger Nixon","Garrett Winters"),
         ("data.max { it.employee_age }.employee_age"), equalTo(66),
                ("data.min { it.employee_age }.employee_name"), equalTo("Tatyana Fitzpatrick"),
                ("data.sum { it.employee_salary }.toString()"), equalTo("6644770"));

    }

}
