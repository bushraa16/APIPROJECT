package Homework;

import base_urls.homework9Baseurl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class homework7  extends homework9Baseurl {
    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then


            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */
    @Test
    public void homework7 () {
//        spec.pathParams("first","unknown");
//        Response response=given(spec).get("{first}");
        String url = "https://reqres.in/api/unknown/";
        Response response = given().get(url);
        response.prettyPrint();
        response.then().statusCode(200);
        JsonPath jsonPath = response.jsonPath();
        //1)Status code is 200
        //  2)Print all pantone_values
        List<Object> pantone_values = jsonPath.getList(" data.pantone_value");
        System.out.println("pantone_values" + pantone_values);
        //   3)Print all ids greater than 3 on the console
        List<Integer> ListId = jsonPath.getList(" data.id");
        int idsGreaterThan3 = 0;
        for (int id : ListId) {
            if (id > 3) {
                System.out.println("Print all ids greater than 3 on the console" + id);
                idsGreaterThan3++;
            }

        }
        assertEquals(idsGreaterThan3, 3);
        List<String> idlist =jsonPath.setRootPath("data").getList("findAll{it.id<3}.id");
        System.out.println("Print all ids less than 3 on the console" + idlist);
        assertEquals(idlist.size(), 2);

    }
        }


