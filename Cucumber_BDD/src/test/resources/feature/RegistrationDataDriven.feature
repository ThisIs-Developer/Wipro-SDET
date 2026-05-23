Feature: User Registration on Demo Web Shop

  Scenario Outline: Verify successful user registration with valid details

    Given user is on the Demo Web Shop registration page
    When user selects gender as male
    And enters first name "<firstname>"
    And enters last name "<lastname>"
    And enters email "<email>"
    And enters password "<password>"
    And enters confirm password "<confirmpassword>"
    And clicks on the register button
    Then user should see the registration completed message

    Examples:
      | firstname | lastname | email                    | password      | confirmpassword |
      | Hello     | Hola     | hello1@gmail.com         | hola@123      | hola@123        |
      | John      | Wick     | johnwick@gmail.com       | john@123      | john@123        |
      | Harry     | Potter   | harrypotter@gmail.com    | harry@123     | harry@123       |
      | Tony      | Stark    | tonystark@gmail.com      | ironman@123   | ironman@123     |