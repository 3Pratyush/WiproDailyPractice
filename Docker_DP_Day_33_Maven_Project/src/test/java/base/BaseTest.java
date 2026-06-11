package base;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() throws Exception {

        ChromeOptions options = new ChromeOptions();

        driver = new RemoteWebDriver(
                new URL("http://selenium:4444/wd/hub"),
                options);

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get(
            "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null)
            driver.quit();
    }
}