package dataDriven;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class POST_DataDriven_testNgDataProvider_UsingArray {
//we are doing object so we can have any datatype like string number or char...

    @DataProvider(name= "dataForPost") // can give any name
    public Object[][] dataForTest(){

        return new Object[][]{
                {"ram1", "poudel1", 1},
                {"ram2", "poudel2", 2}
        };
    }


    @Test(dataProvider = "dataForPost")
    public void test01(String firstName,String lastName, int subject){
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
                    .statusCode(201).log().all();

    }
}
