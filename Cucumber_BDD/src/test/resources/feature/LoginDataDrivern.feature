Feature: verify Login functionality

  Scenario Outline: verify login page
    Given login page should be open in default browser
    When click on username field and add valid user "<username>"
    And then click on password button and enter valid "<password>"
    And now click on submit button "<Status>"
    Then login successfully and redirect to home page

    Examples:
      | username   | password | Status  |
      | username1  | password1| success |
      | jefggf988765 | passw0rd | fail   |
      | username   | bs75     | Fail    |
      | bvfhjwge32 | kj989674 | Fail    |