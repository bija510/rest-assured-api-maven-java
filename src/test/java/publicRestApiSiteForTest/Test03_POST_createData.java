package publicRestApiSiteForTest;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class Test03_POST_createData {

    /***************************************************************************************
 ==============================OR====================================>
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.6</version>
</dependency>
==============================OR====================================>
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-core</artifactId>
    <version>2.12.1</version>
</dependency>
===============================OR===================================>
<!-- https://mvnrepository.com/artifact/org.json.wso2/json -->
<dependency>
    <groupId>org.json.wso2</groupId>
    <artifactId>json</artifactId>
    <version>3.0.0.wso2v1</version>
</dependency>
==============================OR====================================>
<!-- https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple -->
<dependency>
    <groupId>com.googlecode.json-simple</groupId>
    <artifactId>json-simple</artifactId>
    <version>1.1.1</version>
</dependency>
***************************************************************************************/

    @Test
    public void test_postUsing_Map_and_json(){ //Status code= 201 for Successful Post (creation)
        //CREATING
        Map<String, Object> map = new HashMap<String, Object>(); //Map is a key value pair in java object==> means can be any data types
        map.put("name", "David");
        map.put("job", "Panter");
        JSONObject request = new JSONObject(map);
        System.out.println("We are doing this Post "+request.toJSONString());

        //DOING POST
        given()
                .body(request.toJSONString())
                .when()
                    .post("https://reqres.in/api/users")
                .then()
                    .statusCode(201);
    }

    @Test
    public void test_postUsing_only_json(){ //Status code= 201 for Successful Post (creation)
        //CREATING
        JSONObject request = new JSONObject();
        request.put("name", "Ramesh");
        request.put("job", "Teacher");
        System.out.println("We are doing this Post "+request.toJSONString());

        //DOING POST
        given()
                .body(request.toJSONString())
                .when()
                    .post("https://reqres.in/api/users")
                .then()
                    .statusCode(201);
    }

    @Test
    public void test_postUsing_only_json_withHeader(){ //Status code= 201 for Successful Post (creation)
        //CREATING
        JSONObject request = new JSONObject();
        request.put("name", "Ramesh");
        request.put("job", "Teacher");
        System.out.println("We are doing this Post "+request.toJSONString());

        //DOING POST
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                    .post("https://reqres.in/api/users")
                .then()
                    .statusCode(201);
    }
}
