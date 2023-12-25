Feature: Rami Levy website scenarios
  Background:
    Given On Rami-Levy home page
    And Logged in
    When I add item
    | item   |
    | 393870 |
    | 334778 |
    | 349597 |



  Scenario: Add 3 items

    Then validate cart have 3 items



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