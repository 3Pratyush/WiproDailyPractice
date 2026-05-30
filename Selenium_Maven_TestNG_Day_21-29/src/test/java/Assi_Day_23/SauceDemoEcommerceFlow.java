package Assi_Day_23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SauceDemoEcommerceFlow {

    WebDriver driver;

    @BeforeTest
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void loginTest()
            throws InterruptedException {

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        Thread.sleep(1000);

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        Thread.sleep(1000);

        driver.findElement(By.id("login-button"))
                .click();

        Thread.sleep(3000);

        System.out.println("Login Successful");
    }

    @Test(priority = 2)
    public void searchAndProductValidation()
            throws InterruptedException {

        WebElement product =
                driver.findElement(By.xpath(
                "//div[text()='Sauce Labs Backpack']"));

        System.out.println(
                "Product Title : "
                + product.getText());

        Thread.sleep(1000);

        WebElement price =
                driver.findElement(By.xpath(
                "//div[@class='inventory_item_price']"));

        System.out.println(
                "Product Price : "
                + price.getText());

        Thread.sleep(1000);

        WebElement image =
                driver.findElement(By.xpath(
                "//img[@alt='Sauce Labs Backpack']"));

        if(image.isDisplayed()) {

            System.out.println(
                    "Product Image Displayed");
        }

        Thread.sleep(1000);

        image.click();

        Thread.sleep(2000);

        WebElement addToCart =
                driver.findElement(By.id(
                "add-to-cart"));

        if(addToCart.isDisplayed()) {

            System.out.println(
                    "Add To Cart Button Visible");
        }

        Thread.sleep(1000);

        addToCart.click();

        Thread.sleep(2000);

        WebElement cart =
                driver.findElement(By.xpath(
                "//a[@class='shopping_cart_link']"));

        cart.click();

        Thread.sleep(2000);

        WebElement checkout =
                driver.findElement(By.id(
                "checkout"));

        if(checkout.isDisplayed()) {

            System.out.println(
                    "Checkout Button Visible");
        }

        Thread.sleep(2000);

        checkout.click();

        Thread.sleep(2000);

        driver.findElement(By.id("first-name"))
                .sendKeys("Pratyush");

        Thread.sleep(1000);

        driver.findElement(By.id("last-name"))
                .sendKeys("Sahoo");

        Thread.sleep(1000);

        driver.findElement(By.id("postal-code"))
                .sendKeys("751024");

        Thread.sleep(1000);

        WebElement continueBtn =
                driver.findElement(By.id(
                "continue"));

        if(continueBtn.isDisplayed()) {

            System.out.println(
                    "Buy Button Visible");
        }

        continueBtn.click();

        Thread.sleep(3000);
    }

    @AfterTest
    public void closeBrowser() {

        driver.quit();
    }
}
