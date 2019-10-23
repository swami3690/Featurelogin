Feature: Check Login functionality for OrangeHRM
  Background:
    Given User is on homepage


  @login
  Scenario: As a User, I should be able to log-in with valid credentials

    When user enters valid username and password
    And user clicks on login button
    Then user should be logged in and able to see welcome message




  @LoginFailed
  Scenario Outline: Login functionality for OrangeHRM Website

    When I enter Username as "<username>" and Password as "<password>"
    And User click on login button
    Then User should not be logged in with error message "<error_message>"
    Examples:
      | username | password  | error_message            |
      | Admin    | password2 | Invalid credentials      |
      | User     | admin123  | Invalid credentials      |
      | Admin    |           | Password cannot be empty |
      |          | admin123  | Username cannot be empty |
      |          |           | Username cannot be empty |
      | User     |           | Password cannot be empty |
      |          | password2 | Username cannot be empty |