@login
Feature: Login functionality for OpenCart

  As a user, I want to be able to log in to the OpenCart website so that I can access my account and place orders.

  Background:
    Given I am on the OpenCart homepage

  @smoke @regression
  Scenario: Successful login with valid credentials
    Given I click on the "My Account" link
    And I click on the "Login" option
    When I enter a valid username "satish@mailinator.com"
    And I enter a valid password "Password@1"
    And I click the "Login" button
    Then I should be redirected to the "My Account" page
    And I should see the message "Welcome back, test@example.com!"

  @regression
  Scenario: Unsuccessful login with invalid credentials
    Given I click on the "My Account" link
    And I click on the "Login" option
    When I enter an invalid username "invalid@example.com"
    And I enter an invalid password "wrongpassword"
    And I click the "Login" button
    Then I should see an error message "Warning: No match for E-Mail Address and/or Password."

  @regression
  Scenario: Unsuccessful login with empty fields
    Given I click on the "My Account" link
    And I click on the "Login" option
    And I click the "Login" button
    Then I should see an error message "Warning: E-Mail Address and/or Password is required."


