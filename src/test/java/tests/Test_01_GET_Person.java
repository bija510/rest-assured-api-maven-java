package tests;

import helpers.PersonServiceHelper;
import model.Person;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import java.util.List;

public class Test_01_GET_Person {
    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init() {
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testGetAllpersons() {
        List<Person> personList = personServiceHelper.getAllPerson();
        assertNotNull(personList, "person list is Not empty");
        assertFalse(personList.isEmpty(), "personLists list is empty");
    }

}
