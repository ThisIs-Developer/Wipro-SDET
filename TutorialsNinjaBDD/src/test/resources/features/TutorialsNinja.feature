Feature: Tutorials Ninja Automation

  @Regreassion
  Scenario: Register User
    Given user opens TutorialsNinja website
    When user registers with valid details
    Then registration should be successful

  @Smoke
  Scenario: Login User
    When user logs in using excel data
    Then login should be successful
  
  @Regreassion
  Scenario Outline: Search Product
    When user searches for <product>
    Then search should complete

    Examples:
      | product   |
      | phone     |
      | Sony VAIO |
      | tab       |
  
  @Smoke
  Scenario Outline: Add Product To Cart
    When user adds <product> to cart
    Then product should be added successfully

    Examples:
      | product   |
      | phone     |
      | Sony VAIO |
      | tab       |
  
  @Smoke
  Scenario: Remove Products
    When user removes products from cart
    Then cart should update
  
  @Smoke
  Scenario: Checkout Product
    When user proceeds to checkout
    Then checkout page should open
  
  @Smoke
  Scenario: Logout User
    When user logs out
    Then logout should be successful