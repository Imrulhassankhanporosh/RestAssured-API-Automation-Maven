package Utility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.baseURI;

public class TestCaseForExcelWrite {

    @Test
    public void postTest() throws IOException {

        String excelPath = "./Data/TestData.xlsx";
        String sheetName1 = "sheet1";

        ExcelUtilities utilities = new ExcelUtilities(excelPath, sheetName1);

        ExcelDataWrite excelDataWrite = new ExcelDataWrite();


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


        RequestSpecification requestSpecification= RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(request.toJSONString());

        Response response = requestSpecification.post("/users");

        if(response.statusCode() == 201){

            excelDataWrite.writeIntoExcel(excelPath,1,4,"Success");
            excelDataWrite.writeIntoExcel(excelPath,1,5,response.asPrettyString());


        }

        else {

            excelDataWrite.writeIntoExcel(excelPath,1,4,"Failed");
            excelDataWrite.writeIntoExcel(excelPath,1,5,response.asPrettyString());

        }



    }
}
