package Homework;

import base_urls.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.*;

import java.util.ArrayList;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class homework12 {
    //Write an automation test that will create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
//(All actions must be done on same pet)
         //   (Use Pojo)
/*
{
    "id": 7653897,
    "category": {
        "id": 0,
        "name": "Cat"
    },
    "name": "Kitty",
    "photoUrls": [
        "string",
        "best foto",
        "beauty"
    ],
    "tags": [
        {
            "id": 0,
            "name": "Smooth"
        },
        {
            "id": 2,
            "name": "White"
        }
    ],
    "status": "available"
}
 */
    @Test(priority = 1)
    public void Posturlandupdate() {
        String url = "https://petstore.swagger.io/v2/pet";
        categoryDatepojo category = new categoryDatepojo(0, "Cat");
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("best foto");
        photoUrls.add("beauty");
        tagspojo tags = new tagspojo(0, "smith");


        homework12pojo expectedData = new homework12pojo(7653897, category, "Kitty", photoUrls, tags, "available");
        System.out.println("expectedData = " + expectedData);
       // PetPojo expectedData = convertJsonToJava(strJson, PetPojo.class);


        //Send the request and get the response
        Response response = given().contentType(ContentType.JSON).body(expectedData).post(url);
        response.prettyPrint();
        //Do assertion
        homework12pojo actualData = convertJsonToJava(response.asString(), homework12pojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getId(), expectedData.getId());
       // assertEquals(actualData.getCategoryDatepojo().getName(), expectedData.getCategoryDatepojo().getName());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getPhotoUrls().getFirst(), expectedData.getPhotoUrls().getFirst());
        assertEquals(actualData.getPhotoUrls().get(1), expectedData.getPhotoUrls().get(1));
       // assertEquals(actualData.getTagsDatapojo().getName(), expectedData.getTagsDatapojo().getName());
        assertEquals(actualData.getstatus(), expectedData.getstatus());









//        System.out.println("pojo = " + expectedData);
//        Response response = given()
//                .body(expectedData)
//                .post(url);
//        response.prettyPrint();

//        homework12pojo actualData = convertJsonToJava(response.asString(), homework12pojo.class);
//        System.out.println("actualData = " + actualData);



//        assertEquals(response.statusCode(), 200);
//        assertEquals(expectedData.getCategoryDatepojo().getCat(), "");
//        assertEquals(expectedData.getCategoryDatepojo().getId(),0);
//        assertEquals(expectedData.getName(), "[best foto, beauty]");
//        assertEquals(expectedData.getName(), "[best foto, beauty]");
    }
//    @Test(priority = 2, dependsOnMethods = "Posturlandupdate")
//    public void geturl(){
//        String url="https://petstore.swagger.io/v2/pet/7653897";
//        Response response=given().get(url);
//        response.prettyPrint();
//    }
//    @Test(priority = 3, dependsOnMethods = "geturl")
//    public void updateUrl() {
//        String url = "https://petstore.swagger.io/v2/pet";
//        // Create the updated JSON payload
//        homework12pojo updatedPayload = new homework12pojo();
//        updatedPayload.setName("Kitty");
//
//        // Send the PUT request with the updated payload
//        Response response = given()
//                .contentType(ContentType.JSON)
//                .body(updatedPayload.toString())
//                .put(url);
//
//        // Deserialize the response into the homework12pojo class
//        homework12pojo homework12pojo = response.as(homework12pojo.class);
//        // Access the updated name
//        String updatedName = homework12pojo.getName();
//        System.out.println("Updated name: " + updatedName);
//
//        // Print the response
//        response.prettyPrint();
//    }
//    @Test(priority = 3, dependsOnMethods = "updateUrl")
//    public void deleturl(){
//        String url="https://petstore.swagger.io/v2/pet/7653897";
//        Response response = given().delete(url);//First create a data and delete it. Do not delete some else's data.
//        response.prettyPrint();
//    }
}