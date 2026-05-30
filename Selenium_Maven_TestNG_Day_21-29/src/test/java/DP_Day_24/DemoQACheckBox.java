package DP_Day_24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQACheckBox {

    public static void main(String[] args)
            throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/checkbox");

        Thread.sleep(3000);

        driver.findElement(By.xpath(
                "//span[@aria-label='Select Home']"))
                .click();

        Thread.sleep(3000);

        String result =
                driver.findElement(By.id("result"))
                .getText();

        System.out.println(result);

        Thread.sleep(3000);

        driver.quit();
    }
}