package DP_Day_24;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQARegistration {

    public static void main(String[] args)
            throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");

        Thread.sleep(3000);

        driver.findElement(By.id("firstName"))
                .sendKeys("Pratyush");

        Thread.sleep(1000);

        driver.findElement(By.id("lastName"))
                .sendKeys("Sahoo");

        Thread.sleep(1000);

        driver.findElement(By.id("userEmail"))
                .sendKeys("pratyush@gmail.com");

        Thread.sleep(1000);

        driver.findElement(By.xpath(
                "//label[text()='Male']"))
                .click();

        Thread.sleep(1000);

        driver.findElement(By.id("userNumber"))
                .sendKeys("9876543210");

        Thread.sleep(1000);

        driver.findElement(By.id("dateOfBirthInput"))
                .click();

        Thread.sleep(1000);

        driver.findElement(By.xpath(
                "//div[contains(@class,'react-datepicker__day--015')]"))
                .click();

        Thread.sleep(1000);

        driver.findElement(By.id("subjectsInput"))
                .sendKeys("Computer Science");

        Thread.sleep(1000);

        driver.findElement(By.xpath(
                "//label[text()='Sports']"))
                .click();

        Thread.sleep(1000);

        driver.findElement(By.id("currentAddress"))
                .sendKeys("Bhubaneswar, Odisha");

        Thread.sleep(1000);

        WebElement state =
                driver.findElement(By.id("state"));

        state.click();

        Thread.sleep(1000);

        driver.findElement(By.xpath(
                "//div[text()='NCR']"))
                .click();

        Thread.sleep(1000);

        WebElement city =
                driver.findElement(By.id("city"));

        city.click();

        Thread.sleep(1000);

        driver.findElement(By.xpath(
                "//div[text()='Delhi']"))
                .click();

        Thread.sleep(1000);

        driver.findElement(By.id("submit"))
                .click();

        Thread.sleep(5000);

        System.out.println(
                "Registration Successful");

        driver.quit();
    }
}
