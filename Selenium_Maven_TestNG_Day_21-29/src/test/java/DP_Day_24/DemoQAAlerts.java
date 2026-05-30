package DP_Day_24;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQAAlerts {

    public static void main(String[] args)
            throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/alerts");

        Thread.sleep(3000);

        driver.findElement(By.id("alertButton"))
                .click();

        Thread.sleep(2000);

        Alert alert1 = driver.switchTo().alert();

        System.out.println(
                "Simple Alert Text : "
                + alert1.getText());

        alert1.accept();

        Thread.sleep(3000);

        driver.findElement(By.id("timerAlertButton"))
                .click();

        Thread.sleep(6000);

        Alert alert2 = driver.switchTo().alert();

        System.out.println(
                "Timer Alert Text : "
                + alert2.getText());

        alert2.accept();

        Thread.sleep(3000);

        driver.findElement(By.id("confirmButton"))
                .click();

        Thread.sleep(2000);

        Alert alert3 = driver.switchTo().alert();

        System.out.println(
                "Confirmation Alert Text : "
                + alert3.getText());

        alert3.dismiss();

        Thread.sleep(3000);

        String confirmResult =
                driver.findElement(By.id("confirmResult"))
                .getText();

        System.out.println(confirmResult);

        Thread.sleep(3000);

        driver.findElement(By.id("promtButton"))
                .click();

        Thread.sleep(2000);

        Alert alert4 = driver.switchTo().alert();

        alert4.sendKeys("Pratyush");

        Thread.sleep(2000);

        alert4.accept();

        Thread.sleep(3000);

        String promptResult =
                driver.findElement(By.id("promptResult"))
                .getText();

        System.out.println(promptResult);

        Thread.sleep(3000);

        driver.quit();
    }
}