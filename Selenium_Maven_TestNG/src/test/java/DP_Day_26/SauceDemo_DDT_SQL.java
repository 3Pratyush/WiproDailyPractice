package DP_Day_26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemo_DDT_SQL {

    public static void main(String[] args) {

        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url =
                    "jdbc:mysql://localhost:3306/SauceDemo";

            String dbUsername = "root";
            String dbPassword = "Lostfiber@8";

            con = DriverManager.getConnection(
                    url,
                    dbUsername,
                    dbPassword);

            stm = con.createStatement();

            // Fetch data from SQL table
            String query =
                    "SELECT username, password FROM login_data";

            rs = stm.executeQuery(query);

            // Loop through each record
            while (rs.next()) {

                String username = rs.getString("username");
                String password = rs.getString("password");

                System.out.println(
                        "Testing Login With : "
                                + username);

                // Launch Browser
                WebDriver driver =
                        new ChromeDriver();

                driver.manage()
                        .window()
                        .maximize();

                driver.manage()
                        .timeouts()
                        .implicitlyWait(
                                Duration.ofSeconds(10));

                // Open SauceDemo Website
                driver.get(
                        "https://www.saucedemo.com/");

                // Enter Username
                driver.findElement(
                        By.id("user-name"))
                        .sendKeys(username);

                // Enter Password
                driver.findElement(
                        By.id("password"))
                        .sendKeys(password);

                // Click Login
                driver.findElement(
                        By.id("login-button"))
                        .click();

                Thread.sleep(3000);

                // Validation
                try {

                    WebElement products =
                            driver.findElement(
                                    By.xpath(
                                            "//span[text()='Products']"));

                    if (products.isDisplayed()) {

                        System.out.println(
                                "Login Successful for : "
                                        + username);
                    }

                } catch (Exception e) {

                    WebElement error =
                            driver.findElement(
                                    By.xpath(
                                            "//h3[@data-test='error']"));

                    System.out.println(
                            "Login Failed for : "
                                    + username);

                    System.out.println(
                            "Error Message : "
                                    + error.getText());
                }
                
                driver.quit();

                System.out.println(
                        "================================");
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (rs != null)
                    rs.close();

                if (stm != null)
                    stm.close();

                if (con != null)
                    con.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}
