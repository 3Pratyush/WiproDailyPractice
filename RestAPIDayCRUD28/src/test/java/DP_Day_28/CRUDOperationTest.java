package DP_Day_28;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.http.ContentType;

public class CRUDOperationTest
{
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setup()
    {
        extent = ExtentManager.getReportObject();
    }

    @DataProvider(name = "userdata")
    public Object[][] getData() throws IOException
    {
        return ExcelUtils.getExcelData();
    }

    // CREATE USER (POST)

    @Test(dataProvider = "userdata", priority = 1)
    public void createUser(String id, String firstName, String lastName, String age)
    {
        test = extent.createTest("Create User API Test");

        HashMap<String, Object> data = new HashMap<String, Object>();

        data.put("id", Integer.parseInt(id));
        data.put("firstName", firstName);
        data.put("lastName", lastName);
        data.put("age", Integer.parseInt(age));

        given()

            .contentType(ContentType.JSON)
            .body(data)

        .when()

            .post("https://dummyjson.com/users/add")

        .then()

            .statusCode(anyOf(is(200), is(201)))
            .log().all();

        test.pass("POST Request Executed Successfully");
    }

    // READ USER (GET)

    @Test(dataProvider = "userdata", priority = 2)
    public void getUser(String id, String firstName, String lastName, String age)
    {
        test = extent.createTest("GET User API Test");

        given()

        .when()

            .get("https://dummyjson.com/users/" + id)

        .then()

            .statusCode(anyOf(is(200), is(404)))
            .log().all();

        test.pass("GET Request Executed Successfully");
    }

    // UPDATE USER (PUT)

    @Test(priority = 3)
    public void updateUser()
    {
        test = extent.createTest("Update User API Test");

        HashMap<String, Object> data = new HashMap<String, Object>();

        data.put("firstName", "UpdatedName");

        given()

            .contentType(ContentType.JSON)
            .body(data)

        .when()

            .put("https://dummyjson.com/users/1")

        .then()

            .statusCode(200)
            .log().all();

        test.pass("PUT Request Executed Successfully");
    }

    // DELETE USER (DELETE)

    @Test(priority = 4)
    public void deleteUser()
    {
        test = extent.createTest("Delete User API Test");

        given()

        .when()

            .delete("https://dummyjson.com/users/1")

        .then()

            .statusCode(200)
            .log().all();

        test.pass("DELETE Request Executed Successfully");
    }

    @AfterTest
    public void tearDown()
    {
        extent.flush();
    }
}