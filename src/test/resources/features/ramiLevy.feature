Feature: Rami Levy website scenarios
  Background:
    Given a logged-in user with credentials 'mahermorsi@gmail.com' and '12345678'
    When I add item
    | item   |
    | 393870 |
    | 334778 |
    | 349597 |



  Scenario Outline: Add items

    Then validate cart item added

    Examples:



  Scenario: Add 3 items validate total price
    And Get price of item
      | item   |
      | 393870 |
      | 334778 |
      | 349597 |
    And Get cart total price
    Then Validate sum equals total


  Scenario: add 3 items delete cart
    And delete cart
    Then validate cart deleted