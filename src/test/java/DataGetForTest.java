import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DataGetForTest extends DataSetForTest {


    @Test(dataProvider = "Data For Post")
    public void PostData(String firstName, String lastName, int subjectId, int id){

        JSONObject request = new JSONObject();

        request.put("firstName",firstName);
        request.put("lastName",lastName);
        request.put("subjectId",subjectId);
        request.put("id",id);

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(request.toJSONString()).
                when().
                post("http://localhost:3000/users").
                then().
                statusCode(201).
                log().all();



    }
}
