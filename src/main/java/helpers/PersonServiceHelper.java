package helpers;

import model.Person;
import utils.ConfigManager;
import com.fasterxml.jackson.core.type.TypeReference;
import constants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.lang.reflect.Type;
import java.util.List;

/*****************************************************
 will have function fetch the data from end points
 GET/POST/PUT/PATCH/DELETE all common methods
 1. We need to read the config variables
 2. rest assured about the URL, port
 3. Make a get REQUEST on this url and send the data to TestGetPerson
 4. Reading the config variables
 *****************************************************/
public class PersonServiceHelper {

    private static final String BASE_URL = ConfigManager.getInstance().getString("base_url");
    private static final String PORT =  ConfigManager.getInstance().getString("port");

    public PersonServiceHelper() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();
    }

    public List<Person> getPerson() {
        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .get(Endpoints.GET_ALL_PERSON)
                .andReturn();
        Type type = new TypeReference<List<Person>>() {}.getType();

        List<Person> personList = response.as(type);
        return personList;
    }

}
