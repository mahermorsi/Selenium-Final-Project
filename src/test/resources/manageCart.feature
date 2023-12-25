Feature: Manage Products

  Background:
    Given i am logged in the website of Rami levi

  Scenario: sending a post request to add three products and validate their count in the cart
    When i send a POST request to add three products
    Then the cart should contain three products
    And validate the product count from the UI

  Scenario: sending a post request to add three products and checking that their price is is correct in the UI
    When i send a Post request to add two products
    And i calculate the sum of these products
    Then validate the total sum element from the page to the calculated sum

  Scenario: sending a request to empty the cart
    When i send a delete request
    Then validate that the cart is empty


