package DP_Day_21;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();


        driver.get("https://www.amazon.in");

       
        driver.manage().window().maximize();

        Thread.sleep(3000);

        
        driver.findElement(By.id("nav-link-accountList")).click();

       
        driver.findElement(By.id("ap_email_login"))
                .sendKeys("8917599639");

        
        driver.findElement(By.id("continue")).click();

        Thread.sleep(2000);

       
        driver.findElement(By.id("ap_password"))
                .sendKeys("Password@12");

        
        driver.findElement(By.id("signInSubmit")).click();

        Thread.sleep(3000);

        driver.get("https://amzn.in/d/0iBmtMTU");
        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys(
                        " Iphone air 17",Keys.ENTER);

        Thread.sleep(5000);

        
        System.out.println(driver.getTitle());

        
        driver.quit();
    }
}