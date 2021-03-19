package helpers;

import model.Person;
import org.apache.http.HttpStatus;
import utils.ConfigManager;
import com.fasterxml.jackson.core.type.TypeReference;
import constants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.lang.reflect.Type;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/*
 will have function fetch the data from end points
 GET/POST/PUT/PATCH/DELETE all common methods
 1. We need to read the config variables
 2. rest assured about the URL, port
 3. Make a get REQUEST on this url and send the data to TestGetPerson
 4. Reading the config variables
 */
public class PersonServiceHelper {

    private static final String BASE_URL = ConfigManager.getInstance().getString("base_url");
    private static final String PORT =  ConfigManager.getInstance().getString("port");

    public PersonServiceHelper() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();
    }
    //GET
    public List<Person> getAllPerson() {
        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .get(Endpoints.GET_ALL_PERSON)
                .andReturn();
        Type type = new TypeReference<List<Person>>() {}.getType();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "OK"); //HttpStatus.SC_OK= 200
        List<Person> personList = response.as(type);
        return personList;
    }
    //POST
    public Response createPerson(){
        //Need to make POST call
        Person person = new Person();
        person.setId(3);
        person.setFirstName("Cavin");
        person.setLastName("poudel");
        person.setPhoneNumbers("7895124678");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(person)
                .post(Endpoints.CREATE_PERSON)
                .andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED, "Created"); //HttpStatus.SC_CREATED= 201

        return response;
    }
    //PATCH
    public Response updatePerson(Integer id){
        Person person = new Person();
        person.setFirstName("Adam");
        person.setLastName("lee");
        person.setAddress("New york");
        person.setAge(39);
        person.setPhoneNumbers("1112223333");

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id", id)
                .when().body(person)
                .patch(Endpoints.UPDATE_PERSON)
                .andReturn();
        assertTrue((response.getStatusCode()==HttpStatus.SC_OK)); // HttpStatus.SC_OK = 200
        return response;
    }
    //DELETE
    public Response deletePerson(Integer id) {
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id", id).log().all()
                .when()
                .delete(Endpoints.DELETE_PERSON)
                .andReturn();
        assertTrue((response.getStatusCode() == HttpStatus.SC_OK)); // HttpStatus.SC_OK = 200
        return response;
    }
}
