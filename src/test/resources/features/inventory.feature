@inventory
Feature: Inventory

  Background:
    When User fills username input field with "standard_user"
    And User fill password input field with "secret_sauce"
    And Click login button
    Then User should be navigated to the homepage



  Scenario: Checking basket number with adding some elements
    Given User is in "saucedemo inventory" page
    When Click to add to card button for 4 elements
    Then Basket number should be matched with added elements


  Scenario:  Checking basket number with adding and removing some elements
    Given User is in "saucedemo inventory" page
    When Click to add to card button for 4 elements
    And Click remove button for two of them
    Then Basket number should be decreased

  Scenario: Checking product details page
    Given User is in "saucedemo inventory" page
    When Click to selected product name for seeing its about page
    Then Product’s details page should be displayed

  Scenario: Adding item to the inventory
    Given User is in "saucedemo inventory" page
    When User clicks add to the card button for any item
    And Clicks to basket button
    Then User should see that item in the basket

  Scenario: Adding item to the inventory and check item after logout and login
    Given User is in "saucedemo inventory" page
    When User clicks add to the card button for any item
    And Clicks menu button
    And Clicks logout btn
    And User fills username input field with "standard_user"
    And User fill password input field with "secret_sauce"
    And Click login button
    And Clicks to basket button
    Then User should see that item in the basket

  Scenario: Deleting item from the inventory
    Given User is in "saucedemo inventory" page
    When User clicks add to the card button for any item
    And Clicks to basket button
    And Clicks to delete button
    Then Item in the basket should be deleted

  Scenario: Successful logout
    Given User is in "saucedemo inventory" page
    When Clicks menu button
    And Clicks logout btn
    Then User should be navigated to login page

  Scenario: Checking if reset app state works properly
    Given User is in "saucedemo inventory" page
    When Clicks menu button
    And Click reset app state button
    Then App state should be resetted

  Scenario: Successful checkout for one product
    Given User is in "saucedemo inventory" page
    When Clicks to basket button
    And Clicks to checkout button
    And User fill First Name input field with "Sadiq"
    And User fill Last Name input field with "Azizov"
    And User fill Postal code input field with "394ifk"
    And Clicks continue button
    And Clicks finish button
    Then Success message should be displayed

  Scenario: Check A to Z filter
    Given User is in "saucedemo inventory" page
    When  User Click A - to Z filter
    Then Items should be ordered as a to z

  Scenario:  Check Z to A filter
    Given User is in "saucedemo inventory" page
    When  User Click Z - to A filter
    Then Items should be ordered as z to a

  Scenario: Check Low to High filter
    Given User is in "saucedemo inventory" page
    When User Click low to high filter
    Then Items should be ordered as low to high price

  Scenario:  Check High to Low filter
    Given User is in "saucedemo inventory" page
    When User Click high to low filter
    Then Items should be ordered as high to low price








