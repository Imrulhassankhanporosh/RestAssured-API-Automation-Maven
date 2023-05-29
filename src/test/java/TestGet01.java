import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestGet01 {


    @Test
    public void testGet01(){

        //Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1"); // without static method

        Response response = get("https://jsonplaceholder.typicode.com/posts/1");  // after declaring static method of restassured


        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode,200);  // Test Case pass

       // Assert.assertEquals(statusCode,201);  // Test Case Fail

    }

    @Test
    public void testGet02(){

        given().get("https://jsonplaceholder.typicode.com/posts/1").then().statusCode(200);
    }
}
