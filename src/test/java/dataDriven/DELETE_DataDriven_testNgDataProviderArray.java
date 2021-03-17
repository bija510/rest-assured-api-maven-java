package dataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DELETE_DataDriven_testNgDataProviderArray {


    @DataProvider(name= "dataForDelete") // can give any name
    public Object[] dataForTest(){

        return new Object[]{
                4, 5, 6
        };
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
