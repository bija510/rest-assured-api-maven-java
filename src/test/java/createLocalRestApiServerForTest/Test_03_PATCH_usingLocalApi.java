package createLocalRestApiServerForTest;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Test_03_PATCH_usingLocalApi {

    //for doing post we need to provide Body

    @Test
    public void test_updatePartial_lastNameOnly(){
        JSONObject request = new JSONObject();
        request.put("lastName", "Doglus");

        baseURI = "http://localhost:3000/";

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                    .patch("/users/4")
                .then()
                    .statusCode(200)
                    .log().all();

    }
}

