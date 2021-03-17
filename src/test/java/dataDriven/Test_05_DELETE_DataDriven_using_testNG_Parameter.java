package dataDriven;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Test_05_DELETE_DataDriven_using_testNG_Parameter {
    // When we have very less number of data we prefer this
    // don't run this class please run the testNG.xml file to run this class
    @Parameters({"userId"})
    @Test()
    public void test_delete_setOfDataByGiving_JsonAutoCreated_ID_Num(int userId){
        System.out.println("value for userId is:"+ userId);
        baseURI = "http://localhost:3000/";

        given()
                .when()
                .delete("/users/"+userId)
                .then()
                .statusCode(200)
                .log().all();

    }

}
