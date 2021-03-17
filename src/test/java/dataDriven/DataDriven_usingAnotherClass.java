package dataDriven;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DataDriven_usingAnotherClass extends DataForTest{

    @Test(dataProvider = "dataForPost")
    public void test_post(String firstName,String lastName, int subject){
        JSONObject request = new JSONObject();
        request.put("firstName", firstName);
        request.put("lastName", lastName);
        request.put("subjectId", subject);

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

    @Test(dataProvider = "dataForDelete")
    public void test_delete_setOfDataByGiving_JsonAutoCreated_ID_Num(int userId){

        baseURI = "http://localhost:3000/";

        given()
                .when()
                .delete("/users/"+userId)
                .then()
                .statusCode(200)
                .log().all();

    }
}
