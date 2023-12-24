Feature: log in
  Scenario: Log in
    Given Rami-Levy home page
    When Click Login
    And Enter "email" and "password" in popup
    And Click Login in popup
    Then validate logged in