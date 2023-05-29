import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TestNGParameterPassTest {

    @Parameters("id") // cam pass only one parameter value , dont know about multiple data pass

    @Test
    public void deleteData(int id){


        given().
                delete("http://localhost:3000/users/"+id).
                then().
                statusCode(200).
                log().all();


    }


}
