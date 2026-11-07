package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    
    private final By usernameField = By.id("username");
    private final By pinField = By.id("pin");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By errorMessage = By.cssSelector(".alert-danger");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPin(String pin) {
        driver.findElement(pinField).clear();
        driver.findElement(pinField).sendKeys(pin);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String pin) {
        enterUsername(username);
        enterPin(pin);
        clickLogin();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}