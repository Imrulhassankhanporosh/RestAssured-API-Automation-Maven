import org.testng.annotations.DataProvider;

public class DataSetForTest {

    @DataProvider(name = "Data For Post")
    public Object[][] dataForPost(){

        return new Object[][] {

                {"Salam","Mia",2,6}
        };
    }


}
