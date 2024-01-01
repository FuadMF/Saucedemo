@yourInformation
Feature: YourInformation


Background:
  When User fills username input field with "standard_user"
  And User fill password input field with "secret_sauce"
  And Click login button
  And Clicks to basket button
  And Clicks to checkout button
  Then User should be navigated to Your Information page


 Scenario Outline: Correct information with "<First Name>" and "<Last Name>" and "<Postal Code>"
   Given User is in "YourInformation" page
   When User fill First Name input field with "<First Name>"
   And User fill Last Name input field with "<Last Name>"
   And User fill Postal code input field with "<Postal Code>"
   And Clicks continue button
   Then User should be navigated to Overview page
   Examples:
     | First Name | Last Name | Postal Code |
     | Fuad       | Mammadli  | 1992f       |
     | Sadiq      | Azizov    | 1995s       |
     | Emil       | Emilov    | 1993e       |
     | Elnur      | Qedimli   | 2000e       |


 Scenario Outline: Incorrect information with ("<Name>")
   Given User is in "YourInformation" page
   When User fill First Name input field with "<First Name>"
   And User fill Last Name input field with "<Last Name>"
   And User fill Postal code input field with "<Postal Code>"
   And Clicks continue button
   Then "<error>" Error message should be displayed
   Examples:
     | Name                                                | First Name | Last Name | Postal Code | error                          |
     | empty firstName empty LastName empty postalCode     |            |           |             | Error: First Name is required  |
     | correct firstName empty LastName empty postalCode   | Fuad       |           |             | Error: Last Name is required   |
     | empty firstName correct LastName empty postalCode   |            | mammadli  |             | Error: First Name is required  |
     | empty firstName empty LastName correct postalCode   |            |           | 1992f       | Error: First Name is required  |
     | empty firstName correct LastName correct postalCode |            | mammadli  | 1992f       | Error: First Name is required  |
     | correct firstName correct LastName empty postalCode | fuad       | mammadli  |             | Error: Postal Code is required |
     | correct firstName empty LastName correct postalCode | fuad       |           | 1992f       | Error: Last Name is required   |



