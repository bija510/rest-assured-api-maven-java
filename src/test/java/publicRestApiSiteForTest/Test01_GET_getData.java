package publicRestApiSiteForTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test01_GET_getData {
/*********************************************************************************************************************
 1. When we create new project then add testNg in Pom.xml TEST RUN FAILED With this Erroe
 2. If you need to explicitly load the DTD from a http url, please do so by using the JVM argument [-Dtestng.dtd.http=true]
 3. then go run==>Edit configuration==>templete==>testNG==>just add this vm options==-ea  -Dtestng.dtd.http=true
 4. Make sure testKind = class that's all
 5. import static io.restassured.RestAssured.*; then no Response.get needed
 6. Install JSON Formatter as chrome extension to view in JSON mode
 7. https://github.com/rest-assured/rest-assured/wiki/GettingStarted
 **********************************************************************************************************************/

    @Test
    public void test_01(){
        //we Are storing the response in variable
        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println("All Response= "+ response.asString()); //print entire response
        System.out.println("Body= "+ response.getBody().toString()); //just printing body
        System.out.println("Status Code= "+response.getStatusCode());
        System.out.println("======================");
        System.out.println("Header content-type= "+response.getHeader("content-type"));
        System.out.println("Total time= "+response.getTime());

        //Validation
        AssertJUnit.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void test_02(){
        given()
        	.header("x-api-key", "reqres-free-v1")
        	.when()
                .get("https://reqres.in/api/users?page=2")
            .then()
                 .statusCode(200)
                  .body("data.id[0]", equalTo(7)) ;
    }
}
