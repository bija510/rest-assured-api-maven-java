package createLocalRestApiServerForTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Test_05_DELETE_usingLocalApi {

    //for doing post we need to provide Body

    @Test
    public void test_updatePartial_firstAndlastName(){

        baseURI = "http://localhost:3000/";

        given()
                .when()
                    .delete("/users/4")
                .then()
                    .statusCode(200)
                    .log().all();

    }
}

