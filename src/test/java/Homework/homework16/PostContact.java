package Homework.homework16;
import base_urls.userTokenBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PostContact extends userTokenBaseUrl {
    /*
  Given
      https://thinking-tester-contact-list.herokuapp.com/users
  And
  {
   "firstName": "Test",
  "lastName": "User",
  "email": "test@fake.com",
  "password": "myPassword"
  }
  When
      Send POST request to the url
  Then
      Status code should be 200
  And
      Response body should be like:
  "user": {
      "_id": "",random
      "firstName": "bushraa",
      "lastName": "alharbi",
      "email": "bushratester@hotmail.com",
      "__v": 1
  },
  "token": "" random

   */
    public static String token;
    @Test
    public void postContactUser(){
        //Set the url
        spec.pathParams("first","contacts");
        //Set the expected data
        String strJson= """
                {
                             "firstName": "John1",
                             "lastName": "Doe1",
                             "birthdate": "1970-02-01",
                              "email": "jdoe@fake2.com",
                              "phone": "80055555552",
                               "street1": "1 Main St2.",
                               "street2": "Apartment A2",
                                "city": "Anytown2",
                                 "stateProvince": "KS2",
                                 "postalCode": "123452",
                                  "country": "USA2"
                         }
                """;
        Map expectedData =ObjectMapperUtils.convertJsonToJava(strJson, Map.class);
        System.out.println(expectedData);
        Response response=given(spec).body(expectedData).post("{first}");
        response.prettyPrint();


    }

}
