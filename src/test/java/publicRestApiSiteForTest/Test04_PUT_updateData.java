package publicRestApiSiteForTest;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Test04_PUT_updateData {

    @Test
    public void test_updateOrCreate_and_verify_statusCode(){
        //For input we need body
        //CREATING
        JSONObject request = new JSONObject();
        request.put("name", "Ramesh");
        request.put("job", "Teacher");
        System.out.println("We are doing this PUT "+request.toJSONString());

        //DOING PUT
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                    .put("https://reqres.in/api/users/2")
                .then()
                    .statusCode(200)
                    .log().all();//To verify we can log all the response it'll print in console

    }
}
