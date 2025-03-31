package org.abc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage {

    public loginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement eMailAddressEle;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordEle;
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginEle;

    public void seteMailAddress(String eMailAddress){
        eMailAddressEle.sendKeys(eMailAddress);
    }

    public void setPassword(String password){
        passwordEle.sendKeys(password);
    }

    public void clickOnLogin(){
        loginEle.click();
    }
}
