package validateJSONSchema;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Test_validate_LocalJsonSchema_WithRemote {

    /****************************************************************************************************************
    WE ARE VALIDATING(VERIFYING MATCH) REMOTE JSON DATA  IN https://reqres.in/api/users?page=2 WITH LOCAL SCHEMA.JSON
     ****************************************************************************************************************
     1. In real work we will get JSON schema(Means Json file) from developer &
    we have to validate that
    2. Copy paste Json data into the Json code beautify
    3. create schema.json file under this path = RESTAssuredApi_Automation\target\classes & paste json data
    4. copy maven dependency
    <!-- https://mvnrepository.com/artifact/io.rest-assured/json-schema-validator -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>json-schema-validator</artifactId>
        <version>4.3.0</version>
    </dependency>
     Refer this :- https://github.com/rest-assured/rest-assured/wiki/GettingStarted#json-schema-validation
     for more info
     ***************************************************************************************************************/
    @Test
    public void test_validate(){ // https://reqres.in/api/users?page=2

        baseURI = "https://reqres.in/api";

        given()
               .get("/users?page=2")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json"))
                .statusCode(200)
                .log().all();
    }
}
