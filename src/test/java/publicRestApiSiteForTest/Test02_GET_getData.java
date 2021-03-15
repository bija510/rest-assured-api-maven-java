package publicRestApiSiteForTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test02_GET_getData {

    @Test
    public void test_verifyStatusCode(){
        given().get("https://reqres.in/api/users?page=2").then().statusCode(200); // will not print any details

    }
    @Test
    public void test_verifyStatusCodeWith_details(){
        given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
    }

    @Test
    public void test_verify_StatusCode_And_Body(){
        given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[1]", equalTo(8));
    }

    @Test
    public void test_verify_statusCode_body_and_multipleBody_JsonArray(){
        given().get("https://reqres.in/api/users?page=2").then().statusCode(200)
                .body("data.id[1]", equalTo(8))
                .body("data.first_name", hasItems("Michael", "Lindsay", "Rachel"));
    }

}
