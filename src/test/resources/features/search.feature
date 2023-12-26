Feature: Search Feature
  Background:
    Given I navigated to "https://www.rami-levy.co.il/"

  Scenario: User searches for a product
    When I search for bread
    Then validate that URL contains bread category

  Scenario: User navigates to a specific product category
    When I click on the Dairy category
    Then validate we are navigated to the correct url

  Scenario: filtering search
    When i search for bread products
    And i filter by the brand fitness
    Then validate that the products are filtered accordingly