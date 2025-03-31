@ui
Feature: OpenCart User Flow
  As a customer, I want to browse products, add them to my cart, and complete the checkout process.

  @regression
  Scenario: User adds a product to the cart
    Given the user is on the OpenCart homepage
    When the user clicks on the "Laptops" category
    And the user clicks on a specific product "MacBook Air"
    And the user clicks on "Add to Cart"
    Then the product "MacBook Air" should be added to the cart
    And the cart count should be 1