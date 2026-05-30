package DP_Day_29;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.restassured.response.Response;

public class RequestChainingTest {

    ExtentReports extent;
    ExtentTest test;

    int userId;

    @BeforeTest
    public void setupReport() {

        // Report location
        ExtentSparkReporter spark =
                new ExtentSparkReporter("test-output/APIReport.html");

        spark.config().setReportName("API Automation Report");
        spark.config().setDocumentTitle("Rest Assured Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("Tester", "Shaurya");
        extent.setSystemInfo("Framework", "Rest Assured + TestNG");
    }

    @Test(priority = 1)
    public void createUser() {

        test = extent.createTest("Create User API");

        String requestBody = "{\n" +
                "  \"firstName\": \"Shaurya\",\n" +
                "  \"lastName\": \"Chattopadhyay\",\n" +
                "  \"age\": 22\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)

        .when()
                .post("https://dummyjson.com/users/add")

        .then()
                .extract().response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);

        userId = response.jsonPath().getInt("id");

        test.pass("User Created Successfully");
        test.info("Generated User ID: " + userId);
    }

    @Test(priority = 2)
    public void getUser() {

        test = extent.createTest("Get User API");

        Response response = given()

        .when()
                .get("https://dummyjson.com/users/" + userId)

        .then()
                .extract().response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);

        test.pass("User Fetched Successfully");
    }

    @Test(priority = 3)
    public void updateUser() {

        test = extent.createTest("Update User API");

        String updatedBody = "{\n" +
                "  \"firstName\": \"Updated Shaurya\",\n" +
                "  \"age\": 23\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(updatedBody)

        .when()
                .put("https://dummyjson.com/users/" + userId)

        .then()
                .extract().response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);

        test.pass("User Updated Successfully");
    }

    @Test(priority = 4)
    public void deleteUser() {

        test = extent.createTest("Delete User API");

        Response response = given()

        .when()
                .delete("https://dummyjson.com/users/" + userId)

        .then()
                .extract().response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);

        test.pass("User Deleted Successfully");
    }

    @AfterTest
    public void tearDown() {

        extent.flush();

        System.out.println("Report Generated Successfully");
    }
}