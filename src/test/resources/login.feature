Feature: log in
  Scenario: Log in
    Given Rami-Levy home page
    When Click Login
    And Enter 'mahermorsi@gmail.com' and '12345678' in popup
    And Click Login in popup
    Then validate logged in