package dataDriven;

import org.testng.annotations.DataProvider;

public class DataForTest {


    @DataProvider(name= "dataForPost") // can give any name
    public Object[][] dataForPosts(){

        return new Object[][]{
                {"ram1", "poudel1", 1},
                {"ram2", "poudel2", 2}
        };
    }

    @DataProvider(name= "dataForDelete") // can give any name
    public Object[] dataForDeletes(){

        return new Object[]{
                3, 4, 5
        };
    }
}
