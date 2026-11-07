package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BankingDashboardPage;
import pages.LoginPage;

public class FundTransferTest extends BaseTest {

    @Test(priority = 1, description = "TC004: Fund transfer ₹500 executes successfully")
    public void testSuccessfulTransfer() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ayush_test", "1234");

        BankingDashboardPage dashboard = new BankingDashboardPage(driver);
        dashboard.transferFunds("ACC987654", "500");

        String alertText = dashboard.getTransactionStatus();
        Assert.assertTrue(alertText.contains("Transfer successful"),
            "Transaction confirmation message should be displayed");
    }

    @Test(priority = 2, description = "TC005: Transfer amount exceeding balance is rejected")
    public void testInsufficientBalanceTransfer() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ayush_test", "1234");

        BankingDashboardPage dashboard = new BankingDashboardPage(driver);
        dashboard.transferFunds("ACC987654", "50000");

        String alertText = dashboard.getTransactionStatus();
        Assert.assertTrue(alertText.contains("Insufficient funds"),
            "Transaction should be rejected due to low balance");
    }
}
