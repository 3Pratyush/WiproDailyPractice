package test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void login() throws Exception {

        ChromeOptions options = new ChromeOptions();

        WebDriver driver =
                new RemoteWebDriver(
                        new URL("http://selenium-hub:4444/wd/hub"),
                        options);

        driver.get("https://opensource-demo.orangehrmlive.com/");

        Thread.sleep(10000);

        driver.findElement(
                By.xpath("//input[@placeholder='Username']"))
                .sendKeys("Admin");

        driver.findElement(
                By.xpath("//input[@placeholder='Password']"))
                .sendKeys("admin123");

        driver.findElement(
                By.xpath("//button[@type='submit']"))
                .click();

        Thread.sleep(5000);

        System.out.println("Login Successful");

        driver.quit();
    }
}