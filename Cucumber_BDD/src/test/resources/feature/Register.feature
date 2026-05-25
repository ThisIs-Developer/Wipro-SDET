Feature: User Registration on Demo Web Shop

  Scenario Outline: Verify successful user registration with valid details
    Given user is on the Demo Web Shop registration page
    When user selects gender as male
    And enters first name "<first_name>"
    And enters last name "<last_name>"
    And enters email "<email>"
    And enters password "<password>"
    And enters confirm password "<confirm_password>"
    And clicks on the register button
    Then user should see the registration completed message

    Examples:
      | first_name   | last_name | email                    | password   | confirm_password  |
      | Test1        | Hello     | test32154345@gmail.com   | test@123   | test@123          |
      | Test2        | Hi        | test23453254@gmail.com   | hello@123  | hello@123         |