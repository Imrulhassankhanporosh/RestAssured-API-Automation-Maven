package Utility;


import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ExcelDataReadTest {

    @Test
    public void testExcelData() {

        String excelPath = "./Data/TestData.xlsx";
        String sheetName1 = "sheet1";

        ExcelUtilities utilities = new ExcelUtilities(excelPath, sheetName1);


        Object data1 = utilities.getCellData(1, 0);
        Object data2 = utilities.getCellData(1, 1);
        Object data3 = utilities.getCellData(1, 2);
        Object data4 = utilities.getCellData(1,3);

        JSONObject request = new JSONObject();


        request.put("firstName",data1);
        request.put("lastName",data2);
        request.put("subjectId",data3);
        request.put("id",data4);

        System.out.println(request);

        baseURI = "http://localhost:3000/";


            given().
                    contentType(ContentType.JSON).
                    accept(ContentType.JSON).
                    header("Content-Type", "application/json").
                    body(request.toJSONString()).
                    when().
                    post("/users").
                    then().
                    statusCode(201).
                    log().all();



    }

}
