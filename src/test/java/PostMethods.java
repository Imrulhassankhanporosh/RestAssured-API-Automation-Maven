import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PostMethods {

    @Test
    public void postCases(){

        //using mapping to create JSON Object request body

//        Map<String, Object> map = new HashMap<String, Object>();
//
//        map.put("name", "morpheus");
//        map.put("job", "leader");
//        System.out.println(map);
//
//
//        JSONObject request = new JSONObject(map);
//        System.out.println(request);

        JSONObject request = new JSONObject();
        request.put("name", "morpheus");
        request.put("job", "leader");

        // System.out.println(request);

        given().
                body(request.toJSONString()).
                post("https://reqres.in/api/users").
                then().
                statusCode(201).
                log().all();



    }
}
