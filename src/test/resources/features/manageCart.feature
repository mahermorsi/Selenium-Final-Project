Feature: Manage Products

  Background:
    Given I am in Rami-Levy home page
    And Click Login
    And Enter 'mahermorsi@gmail.com' and '12345678' in popup
    And Click Login in popup


  Scenario: sending a post request to add three products and validate their count in the cart
    When i send a POST request to add three products
    Then the cart should contain three products

  Scenario: sending a post request to add two products and checking that their price is correct in the UI
    When i send a Post request to add two products
    And i calculate the sum of these products
    Then validate the total sum element from the page to the calculated sum

  Scenario: sending a request to empty the cart
    When i send a delete request
    Then validate that the cart is empty


