package Homework;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class homework6 {
    /*
      Given
        https://reqres.in/api/unknown/3
      When
          User send a GET request to the URL
      Then
          HTTP Status Code should be 200
      And
          Response content type is "application/json; charset=utf-8"
      And
          Response body should be like;(Soft Assertion)
      {
      "data": {
          "id": 3,
          "name": "true red",
          "year": 2002,
          "color": "#BF1932",
          "pantone_value": "19-1664"
      },
      "support": {
          "url": "https://reqres.in/#support-heading",
          "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
      }
}
    */
   @Test
    public void homework6(){
      String url="https://reqres.in/api/unknown/3";
       Response response=given().get(url);
       response.then()
               .statusCode(200)
               .contentType("application/json; charset=utf-8");
              /* .body("data.id",equalTo(3)
                       ," data.name",equalTo("true red"),
                       "data.year",equalTo(2002),
                       "data.color",equalTo("#BF1932"),
                       "data.pantone_value",equalTo("19-1664"),
                       "support.url",equalTo("https://reqres.in/#support-heading"),
                       "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));*/
       JsonPath jsonPath = response.jsonPath();
       int id = jsonPath.getInt("data.id");
       String name = jsonPath.getString("data.name");
       int year = jsonPath.getInt("data.year");
       String color = jsonPath.getString("data.color");
       String pantone_value = jsonPath.getString("data.pantone_value");
       String url1 = jsonPath.getString("support.url");
       String text = jsonPath.getString("support.text");
       assertEquals(id, 3);//If this assertion fails, the subsequent lines won't execute. Because this is Hard Assertion.
       assertEquals(name, "true red");
       assertEquals(year, 2002);
       assertEquals(color, "#BF1932");
       assertEquals(pantone_value, "19-1664");
       assertEquals(url1, "https://reqres.in/#support-heading");
       assertEquals(text, "To keep ReqRes free, contributions towards server costs are appreciated!");
    }
}
