package org.abc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class homePage extends basePage {

    //Constructor
    public homePage(WebDriver driver) {
        super(driver);
    }

    //Locator

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    @CacheLookup
    private WebElement myAccount;
    @FindBy(xpath = "//a[normalize-space()='Register']")
    @CacheLookup
    private WebElement register;


    @FindBy(xpath = "//a[normalize-space()='Login']")
    private WebElement login;

    public void clickMyAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
    }

    public void Clickonregister() {
        register.click();
    }

    public void ClickOnLogin() {
        login.click();
    }


}
