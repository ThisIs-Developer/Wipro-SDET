Feature: User Registration on Demo Web Shop

  Scenario: Verify successful user registration with valid details
    Given user is on the Demo Web Shop registration page
    When user selects gender as male
    And enters first name "Hello"
    And enters last name "Hola"
    And enters email "heelloohola@gmail.com"
    And enters password "holallaa@123"
    And enters confirm password "holallaa@123"
    And clicks on the register button
    Then user should see the registration completed message