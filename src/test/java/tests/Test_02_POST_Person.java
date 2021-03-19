package tests;

import helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;

public class Test_02_POST_Person {
    //init - PersonserviceHelper
    //Assert Create the person and veiry it

    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init() {
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testPOSTCreatePerson(){
        String id = personServiceHelper.createPerson().jsonPath().getString("id");
        System.out.println(id);
        assertNotNull(id, "person id is Not null");

    }
}
