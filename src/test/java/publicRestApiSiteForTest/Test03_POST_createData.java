package publicRestApiSiteForTest;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class Test03_POST_createData {

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
                .header("x-api-key", "reqres-free-v1")
                .body(request.toJSONString())
                .when()
                    .post("https://reqres.in/api/users")
                .then()
                    .statusCode(201)
                    .log()
                    .all();    
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
                .header("x-api-key", "reqres-free-v1")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when()
                    .post("https://reqres.in/api/users")
                .then()
                	.log()
                	.all()
                    .statusCode(201);
    }

}
