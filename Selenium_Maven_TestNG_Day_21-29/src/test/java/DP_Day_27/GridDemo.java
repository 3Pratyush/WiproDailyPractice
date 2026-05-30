package DP_Day_27;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridDemo {

    @SuppressWarnings("deprecation")
	public static void main(String[] args)
            throws Exception {

        WebDriver driver;

        String browser = "chrome";

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options =
                    new ChromeOptions();

            driver =
                    new RemoteWebDriver(

                            new URL(
                                    "http://localhost:4444"),

                            options);

        } else {

            EdgeOptions options =
                    new EdgeOptions();

            driver =
                    new RemoteWebDriver(

                            new URL(
                                    "http://localhost:4444"),

                            options);
        }

        driver.manage().window().maximize();

        driver.get(
                "https://www.saucedemo.com/");

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        System.out.println(
                "Title : "
                        + driver.getTitle());

        Thread.sleep(3000);

        driver.quit();
    }
}