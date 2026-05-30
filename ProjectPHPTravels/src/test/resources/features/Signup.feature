Feature: PHPTravels Registration Module

  @Regression
  Scenario: Validate User Registration with Random Email
    Given user is on the registration page
    When user enters personal details "Baivab" "Sarkar"
    And enters a randomly generated email and password "Baivab@12345"
    And clicks on the signup button
    Then validate successful registration