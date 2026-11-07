package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankingDashboardPage {
    private final WebDriver driver;

    private final By balanceDisplay = By.id("account-balance");
    private final By targetAccountField = By.id("targetAccount");
    private final By amountField = By.id("transferAmount");
    private final By submitTransferBtn = By.id("submit-transfer-btn");
    private final By transactionAlert = By.cssSelector(".transaction-status");

    public BankingDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBalance() {
        return driver.findElement(balanceDisplay).getText();
    }

    public void transferFunds(String targetAccount, String amount) {
        driver.findElement(targetAccountField).sendKeys(targetAccount);
        driver.findElement(amountField).sendKeys(amount);
        driver.findElement(submitTransferBtn).click();
    }

    public String getTransactionStatus() {
        return driver.findElement(transactionAlert).getText();
    }
}