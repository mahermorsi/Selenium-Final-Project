Feature: Search Feature
  Background:I am in Rami-Levy home page

  Scenario: User searches for a product
    When I search for product
    Then I see the search results for the product

    And validate that URL contains product category