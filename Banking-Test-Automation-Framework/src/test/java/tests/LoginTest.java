package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "TC001: Valid user credentials login successfully")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ayush_test", "1234");
        
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"), 
            "User should be navigated to dashboard after valid login");
    }

    @Test(priority = 2, description = "TC002: Invalid PIN shows error message")
    public void testInvalidPin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ayush_test", "0000");

        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError, "Invalid credentials. Please verify your PIN.",
            "Error notification should match invalid credentials message");
    }

    @Test(priority = 3, description = "TC007: Submitting blank fields shows validation message")
    public void testEmptyFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();

        String actualError = loginPage.getErrorMessage();
        Assert.assertTrue(actualError.contains("Fields cannot be empty"),
            "Validation alert must trigger on blank submission");
    }
}
