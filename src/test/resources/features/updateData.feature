Feature: updating personal information

  Given navigate to rami levi site
  Scenario: updating personal information
    When i navigate to "https://www.rami-levy.co.il/he/dashboard"
    And fill the informations
    |  name   |  lastname  | phonenumber  |
    |  aleen  |  bibar  |   0549421433  |
    Then  validate that the new info were applied