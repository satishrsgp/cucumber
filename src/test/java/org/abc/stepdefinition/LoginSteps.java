package org.abc.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.abc.driverFactory.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class LoginSteps {
    WebDriver driver = driverFactory.getDriver();

    @Given("I am on the OpenCart homepage")
    public void i_am_on_the_opencart_homepage() {
        driver.get("https://tutorialsninja.com/demo/index.php");
    }

    @Given("I click on the {string} link")
    public void i_click_on_the_link(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    @Given("I click on the {string} option")
    public void i_click_on_the_option(String optionText) {
        driver.findElement(By.linkText(optionText)).click();
    }

    @When("I enter a valid username {string}")
    public void i_enter_a_valid_username(String username) {
        driver.findElement(By.id("input-email")).sendKeys(username);
    }

    @When("I enter a valid password {string}")
    public void i_enter_a_valid_password(String password) {
        driver.findElement(By.id("input-password")).sendKeys(password);
    }

    @When("I click the {string} button")
    public void i_click_the_button(String buttonText) {
        driver.findElement(By.xpath("//input[@value='" + buttonText + "']")).click();
    }

    @Then("I should be redirected to the {string} page")
    public void i_should_be_redirected_to_the_page(String pageTitle) {
        assertTrue(driver.getTitle().contains(pageTitle));
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String message) {
        String actualMessage = driver.findElement(By.cssSelector("div.alert.alert-success")).getText();
        assertTrue(actualMessage.contains(message));
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String errorMessage) {
        String actualErrorMessage = driver.findElement(By.cssSelector("div.alert.alert-danger")).getText();
        assertTrue(actualErrorMessage.contains(errorMessage));
    }

    @When("I enter an invalid username {string}")
    public void iEnterAnInvalidUsername(String arg0) {

    }

    @And("I enter an invalid password {string}")
    public void iEnterAnInvalidPassword(String arg0) {

    }



}
