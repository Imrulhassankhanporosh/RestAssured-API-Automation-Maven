import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutMethods {

    @Test
    public void putCases(){

        JSONObject request = new JSONObject();
        request.put("name", "morpheus");
        request.put("job", "zion resident");

        given().
                body(request.toJSONString()).
                put("https://reqres.in/api/users/2").
                then().
                statusCode(200).
                log().all();
    }
}
