Feature: Tutorials Ninja Automation

  Background:
    Given user opens TutorialsNinja website

  @Regression @Register
  Scenario: Register User
    When user registers with valid details
    Then registration should be successful

  @Smoke @Login
  Scenario: Login User
    When user logs in using excel data
    Then login should be successful
  
  @Regression @Search
  Scenario Outline: Search Product
    When user searches for <product>
    Then search should complete

    Examples:
      | product   |
      | phone     |
      | Sony VAIO |
      | tab       |
  
  @Smoke @Cart
  Scenario Outline: Add Product To Cart
    When user adds <product> to cart
    Then product should be added successfully

    Examples:
      | product   |
      | phone     |
      | Sony VAIO |
      | tab       |
  
  @Smoke @CartUpdate
  Scenario: Remove Products
    When user removes products from cart
    Then cart should update
  
  @Smoke @Checkout
  Scenario: Checkout Product
    When user proceeds to checkout
    Then checkout page should open
  
  @Smoke @Logout
  Scenario: Logout User
    When user logs out
    Then logout should be successful