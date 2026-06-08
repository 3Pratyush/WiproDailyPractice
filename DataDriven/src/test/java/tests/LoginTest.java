package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import LoginPage.LoginPage;
import utilities.ExcelUtil;

public class LoginTest extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] getData() throws Exception {

        String path = System.getProperty("user.dir")
                + "/src/test/resources/LoginData.xlsx";

        return ExcelUtil.getExcelData(path);
    }

    @Test(dataProvider = "LoginData")
    public void loginTest(String username,
                          String password) {

        LoginPage lp = new LoginPage(driver);

        lp.login(username, password);

        System.out.println(username + " " + password);
    }
}