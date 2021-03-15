package publicRestApiSiteForTest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Test06_DELETE_removeData {

    /*************************************************************************************************************
     For Delete status code is ====204====
     it deletes an existing resource and if the it's already deleted it will most likely throw a 'not found' error.
     We can avoid given() & start with when() also
     *************************************************************************************************************/
    @Test
    public void test_delete_and_verifyStatusCode(){
                 given()
                .when()
                    .delete("https://reqres.in/api/users/2")
                .then()
                         .statusCode(204)
                         .log().all();//To verify we can log all the response it'll print in console

    }
}
