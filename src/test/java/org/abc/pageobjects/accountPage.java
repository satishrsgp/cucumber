package org.abc.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class accountPage extends basePage {
    public accountPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    private WebElement myAccount;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    private WebElement logoutEle;

    // Method to verify the account page is loaded
    public boolean isAccountPage() {
        try {
            // Check if the header or any other unique element on the page is present
            return myAccount.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clinkOnLogout(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",logoutEle);
        logoutEle.click();
    }
}
