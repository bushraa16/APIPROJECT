package Homework.homework13;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class delete {
@Test
public static void deleteUser() {
    String url = "https://petstore.swagger.io/v2";
  Response response = given().delete(url + "/user/bushraa16");
  response.then().statusCode(200);
        }
    }

