package publicRestApiSiteForTest;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Test05_PATCH_updatePartialData {

    /**********************************************************************************************
     PATCH: Submits a partial modification to a resource.
     If you only need to update one field for the resource, you may want to use the PATCH method.
     The difference between PATCH and PUT, is that a PATCH request is non-idempotent (like a POST request).
     The word "idempotent" means that any number of repeated, identical requests will leave the resource in the same state.
     *********************************************************************************************/
    @Test
    public void test_partialUpdate_and_verify_statusCode(){
        //For input we need body
        //CREATING
        JSONObject request = new JSONObject();
        request.put("name", "Ramesh");
        request.put("job", "Teacher");
        System.out.println("We are doing this PATCH==Partial update== "+request.toJSONString());

        //DOING PATCH
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                    .patch("https://reqres.in/api/users/2")
                .then()
                    .statusCode(200)
                    .log().all();//To verify we can log all the response it'll print in console

    }
}
