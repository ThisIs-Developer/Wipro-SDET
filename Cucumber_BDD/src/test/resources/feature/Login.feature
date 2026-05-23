Feature: Login functionality
  
 Scenario: Verify user can log in with valid credentials
  Given the login page is open in the default browser
  When the user enters a valid username in the username field
  And the user enters a valid password in the password field
  And the user clicks the login button
  Then the user should be logged in successfully
  And the user should be redirected to the home page