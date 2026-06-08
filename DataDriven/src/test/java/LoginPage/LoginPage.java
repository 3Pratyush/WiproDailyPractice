package LoginPage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By txtUsername = By.name("username");
    By txtPassword = By.name("password");
    By btnLogin = By.xpath("//button[@type='submit']");

    public void login(String username, String password) {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(txtUsername));

        driver.findElement(txtUsername).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();
    }
}