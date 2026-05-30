package DP_Day_22;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class SauceDemoAutomation {

	    public static void main(String[] args)
	            throws InterruptedException {

	        WebDriver driver = new ChromeDriver();

	        driver.manage().window().maximize();

	        driver.get("https://www.saucedemo.com");

	        driver.findElement(By.id("user-name"))
	                .sendKeys("standard_user");
	        Thread.sleep(1000);

	        driver.findElement(By.id("password"))
	                .sendKeys("secret_sauce");
	        Thread.sleep(1000);

	        driver.findElement(By.id("login-button"))
	                .click();

	        Thread.sleep(2000);

	        driver.findElement(By.xpath(
	                "//div[text()='Sauce Labs Backpack']"))
	                .click();

	        Thread.sleep(2000);

	        driver.findElement(By.xpath(
	                "//button[text()='Add to cart']"))
	                .click();

	        Thread.sleep(2000);

	        driver.findElement(By.xpath(
	                "//a[@class='shopping_cart_link']"))
	                .click();

	        Thread.sleep(2000);

	        driver.findElement(By.id("checkout"))
	                .click();

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

	        driver.findElement(By.id("continue"))
	                .click();

	        Thread.sleep(2000);

	        driver.findElement(By.id("finish"))
	                .click();

	        Thread.sleep(3000);

	        String confirmation =
	                driver.findElement(By.xpath(
	                "//h2[@class='complete-header']"))
	                .getText();

	        System.out.println(
	                "Order Confirmation: " + confirmation);

	        Thread.sleep(3000);

	        driver.quit();
	    }
	}

