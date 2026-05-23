Feature: Product Search Functionality on Demo Web Shop
  Background: User must be logged in successfully
    Given login page should be open in default browser
    When click on email field and enter valid email
    And then click on password field and enter valid password
    And now click on login button

  Scenario: Verify search functionality with a valid keyword
    Given user is on the Demo Web Shop dashboard
    When user enters "laptop" in the search box
    And clicks on the search button
    Then search results should be displayed successfully