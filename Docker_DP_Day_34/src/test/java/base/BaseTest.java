package base;

import java.net.URI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BaseTest

{


public WebDriver driver;

@BeforeMethod

public void setup() throws Exception

{

ChromeOptions option=new ChromeOptions();

WebDriver driver = new RemoteWebDriver (URI.create("http://selenium-hub:4444").toURL(), option);

driver.manage().window().maximize();

}

@AfterMethod

public void tearDown()

{

driver.quit();

}}