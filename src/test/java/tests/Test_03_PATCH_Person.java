package tests;

import helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class Test_03_PATCH_Person {

    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init() {
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testPatchPerson(){
    String id = personServiceHelper.updatePerson(1).jsonPath().getString("id");
        System.out.println(id);
        assertNotNull(id, "Updated");
    }
}
