package org.abc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class customerRegistrationPage extends basePage {

    public customerRegistrationPage(WebDriver driver) {
        super(driver);
    }

    //locators

    @FindBy(xpath = "//input[@id='input-firstname']")
    @CacheLookup
    private WebElement firstName_ele;
    @FindBy(xpath = "//input[@id='input-lastname']")
    @CacheLookup
    private WebElement lastName_ele;
    @FindBy(xpath = "//input[@id='input-email']")
    @CacheLookup
    private WebElement eMail_ele;
    @FindBy(xpath = "//input[@id='input-telephone']")
    @CacheLookup
    private WebElement telephone_ele;
    @FindBy(xpath = "//input[@id='input-password']")
    @CacheLookup
    private WebElement password_ele;
    @FindBy(xpath = "//input[@id='input-confirm']")
    @CacheLookup
    private WebElement passwordConfirm_ele;
    @FindBy(xpath = "//input[@value='0']")
    @CacheLookup
    private WebElement newsletter_ele;
    @FindBy(xpath = "//input[@name='agree']")
    @CacheLookup
    private WebElement agree_ele;
    @FindBy(xpath = "//input[@value='Continue']")
    @CacheLookup
    private WebElement btncontinue_ele;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement Confirmmessgae;

    public void setFirstName(String firstName) {
        firstName_ele.sendKeys(firstName);
    }

    public void setlastname(String lastname) {
        lastName_ele.sendKeys(lastname);
    }

    public void setEmail(String email) {
        eMail_ele.sendKeys(email);
    }

    public void setTelephone(String telephone) {
        telephone_ele.sendKeys(telephone);
    }

    public void setpassword(String Password) {
        password_ele.sendKeys(Password);
    }

    public void setPasswordConfirm(String PasswordConfirm) {
        passwordConfirm_ele.sendKeys(PasswordConfirm);
    }

    public void ClickonNoRadiobtn() {
        newsletter_ele.click();
    }

    public void ClickOnpolicyAgree() {
        agree_ele.click();
    }

    public void ClickonContinue() {
        btncontinue_ele.click();
    }

    public String getConfirmationmsg() {
        return Confirmmessgae.getText();
    }
}
