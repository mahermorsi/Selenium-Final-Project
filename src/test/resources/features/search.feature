Feature: Search Feature
  Background:I am in Rami-Levy home page

  Scenario: User searches for a product
    When I search for product
    Then I see the search results for the product
    And validate that URL contains product category

  Scenario: User navigates to a specific product category
    When I click on the 'Dairy' category
    Then validate we are navigated to "https://www.rami-levy.co.il/he/online/search?q=%D7%9E%D7%95%D7%A6%D7%A8%D7%99%20%D7%97%D7%9C%D7%91"