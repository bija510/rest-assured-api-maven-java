package tests;

import helpers.PersonServiceHelper;
import model.Person;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import java.util.List;

public class TestGETPerson {
    private PersonServiceHelper serviceHelper;

    @BeforeClass
    public void init() {
        serviceHelper = new PersonServiceHelper();
    }

    @Test
    public void testGetAllpersons() {
        List<Person> personList = serviceHelper.getPerson();
        assertNotNull(personList, "personList list is empty");
        assertFalse(personList.isEmpty(), "personLists list is empty");
    }

}
