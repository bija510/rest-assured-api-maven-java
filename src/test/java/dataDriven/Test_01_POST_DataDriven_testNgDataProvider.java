package dataDriven;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Test_01_POST_DataDriven_testNgDataProvider {
//we are doing object so we can have any datatype like string number or char...

    @DataProvider(name= "dataForPost") // can give any name
    public Object[][] dataForTest(){
    Object[][] data = new Object[2][3]; // 2=row, 3=column
        data[0][0] = "adam" ;
        data[0][1] = "buttler" ;
        data[0][2] = 2 ;

        data[1][0] = "binod" ;
        data[1][1] = "lee" ;
        data[1][2] = 1 ;
        return data;
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
                    .statusCode(201)
                    .log().all();

    }
}
