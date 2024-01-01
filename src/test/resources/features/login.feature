@login
Feature: Login

  Scenario Outline: Successful login with "<username>" and "<password>"
    Given User is in "saucedemo web" page
    When User fills username input field with "<username>"
    And User fill password input field with "<password>"
    And Click login button
    Then User should be navigated to the homepage
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |
      | error_user    | secret_sauce |
      | visual_user   | secret_sauce |


    Scenario Outline: Unsuccessful login scenario ("<name>")
      Given User is in "saucedemo web" page
      When User fills username input field with "<username>"
      And User fill password input field with "<password>"
      And Click login button
      Then "<error>" error message should be displayed
      Examples:
        | name                                  | username      | password     | error                                                                     |
        | empty username empty password         |               |              | Epic sadface: Username is required                                        |
        | correct username empty password       | standard_user |              | Epic sadface: Password is required                                        |
        | empty username correct password       |               | secret_sauce | Epic sadface: Username is required                                        |
        | correct username incorrect password   | standard_user | salam123     | Epic sadface: Username and password do not match any user in this service |
        | incorrect username correct password   | salam1234     | secret_sauce | Epic sadface: Username and password do not match any user in this service |
        | incorrect username incorrect password | necesen123    | sagol1234    | Epic sadface: Username and password do not match any user in this service |

















