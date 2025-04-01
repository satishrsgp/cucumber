package org.abc.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.abc.driverFactory.driverFactory;
import org.abc.utils.ConfigReader;
import org.abc.utils.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class openCartScenariosStepDef {
    WebDriver driver = driverFactory.getDriver();

    @Given("the user is on the OpenCart homepage")
    public void givenTheUserIsOnHomePage() {
        LogUtil.info("Opening the application...");
        driver.get(hooks.getConfigValue("baseURL"));
    }

    @When("the user clicks on the {string} category")
    public void whenUserClicksOnCategory(String category) {
        WebElement categoryElement = driver.findElement(By.linkText(category));
        categoryElement.click();
    }

    @When("the user clicks on a specific product {string}")
    public void whenUserClicksOnProduct(String product) {
        WebElement productElement = driver.findElement(By.linkText(product));
        productElement.click();
    }

    @When("the user clicks on {string}")
    public void whenUserClicksOnButton(String button) {
        WebElement buttonElement = driver.findElement(By.name(button));
        buttonElement.click();
    }

    @Then("the product {string} should be added to the cart")
    public void thenProductShouldBeInCart(String product) {
        WebElement cart = driver.findElement(By.id("cart"));
        cart.click();
        WebElement cartProduct = driver.findElement(By.linkText(product));
        assert cartProduct.isDisplayed();
    }

    @Then("the cart count should be {int}")
    public void thenCartCountShouldBe(int count) {
        WebElement cartCount = driver.findElement(By.cssSelector(".cart-count"));
        assert Integer.parseInt(cartCount.getText()) == count;
    }

    @Then("the user should be redirected to the checkout page")
    public void thenUserShouldBeRedirectedToCheckout() {
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("checkout");
    }

    @Then("the order summary should contain the product {string}")
    public void thenOrderSummaryContainsProduct(String product) {
        WebElement orderSummary = driver.findElement(By.id("order-summary"));
        WebElement orderProduct = orderSummary.findElement(By.linkText(product));
        assert orderProduct.isDisplayed();
    }

    @Then("the order should be successfully placed")
    public void thenOrderShouldBePlaced() {
        WebElement confirmationMessage = driver.findElement(By.id("confirmation-message"));
        assert confirmationMessage.isDisplayed();
    }

    @Then("the user should see a confirmation message {string}")
    public void thenUserShouldSeeConfirmationMessage(String message) {
        WebElement confirmationMessage = driver.findElement(By.id("confirmation-message"));
        assert confirmationMessage.getText().equals(message);
    }

    @Given("the user has added a product to the cart")
    public void theUserHasAddedAProductToTheCart() {
    }
}
