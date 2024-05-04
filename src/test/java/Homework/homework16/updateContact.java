package Homework.homework16;

import base_urls.userTokenBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class updateContact extends userTokenBaseUrl{
        @Test
        void updateContactTest(){
            //Set the url
            spec.pathParams("first", "contacts");

            //Set the expected Data
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
                                  "country": "Makkah"
                  
                         }
                """;
            Map expectedData = ObjectMapperUtils.convertJsonToJava(strJson, Map.class);//In patch request Map payload is recommended.
            System.out.println("expectedData = " + expectedData);
            //Send the request and get the response
            Response response = given(spec).body(expectedData).patch("{first}");
            response.prettyPrint();

            //...
        }

    }



