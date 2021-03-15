package createLocalRestApiServerForTest;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Test_02_POST_usingLocalApi {

    //for doing post we need to provide Body

    @Test
    public void test01(){
        JSONObject request = new JSONObject();
        request.put("firstName", "Tom");
        request.put("lastName", "Copper");
        request.put("subjectId", "4");

        baseURI = "http://localhost:3000/";

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                    .post("/users")
                .then()
                    .statusCode(201)
                    .log().all();

    }
}

