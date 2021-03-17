package createLocalRestApiServerForTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Test_01_GET_usingLocalApi {

    /***********************************************************************************
     tool call Mockoon to create api
     too like json-server github==> https://github.com/typicode/json-server
     To get JSON_SERVER AutoInstall Just run this Command ==> npm install -g json-server
     =====================================================================================
     1. After this just run:- npx json-server --watch ddTest.json==>i will create new if not exist
     2. But we have already created so to run==>npx json-server --watch LocalApi.json
     3. now Go to chrome and run http://localhost:3000/
     4. json file path:- C:\Users\Bijaya Chhetri\LocalApi.json
     =====================================================================================
     then it will create json file and put date there
     open this in chrome:- http://localhost:3000/
     and the path where it is install is C:\Users\Bijaya Chhetri\LocalApi.json
     /***********************************************************************************
     http://localhost:3000/subjects
     http://localhost:3000/users
     http://localhost:3000/users/1

     http://localhost:3000/subjects/1/users
     http://localhost:3000/subjects/2/users
     http://localhost:3000/subjects?name=Automation
     ***********************************************************************************/
    @Test
    public void test_using_localMockApi() {
        baseURI = "http://localhost:3000/";
        given()
                .get("/users")
                .then()
                    .statusCode(200)
                    .log().all();


    }

    @Test
    public void test_using_localMockApi_parameter() {
        //MATCHING :-http://localhost:3000/subjects?name=Automation

        baseURI = "http://localhost:3000/";
        given()
                .param("name", "Automation")
                .get("/subjects")
                .then()
                    .statusCode(200)
                    .log().all();
    }

}
