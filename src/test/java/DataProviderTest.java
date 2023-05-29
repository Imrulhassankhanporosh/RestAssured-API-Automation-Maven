import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.given;

public class DataProviderTest {

    @DataProvider(name = "Data For Post")
    public Object[][] dataForPost(){  // passing the data using data provider in same class

        //using data provider method to provide the request data for specific no of row and column by setting the data and return data

//        Object[][] data = new Object[2][4];
//
//        data[0][0] = "Imrul";
//        data[0][1] = "Hassan";
//        data[0][2] = 1;
//        data[0][3] = 4;
//
//        data[1][0] = "Adbur";
//        data[1][1] = "Rahim";
//        data[1][2] = 2;
//        data[1][3] = 5;
//
//        return data;

        //using data provider method to provide the request data for unknown no of row and column by returning the data directly

        return new Object[][]{

                {"Gofur","Mia",2,6},
                {"Karim","Mia",1,7}

        };


    }

    @Test(dataProvider = "Data For Post")
    public void postData(String firstName, String lastName, int subjectId, int id){

        JSONObject request = new JSONObject();

        request.put("firstName",firstName);
        request.put("lastName",lastName);
        request.put("subjectId",subjectId);
        request.put("id",id);

        System.out.println(request);

        baseURI="http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().all();
    }

    @DataProvider(name = "Data For Delete")
    public Object[] dataForDelete(){

        return new Object[]{

                6,7
        };



    }

    @Test(dataProvider = "Data For Delete")
    public void deleteData(int id){


        given().
                delete("http://localhost:3000/users/"+id).
                then().
                statusCode(200).
                log().all();


    }


}
