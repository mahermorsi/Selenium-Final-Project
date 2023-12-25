#Feature: log in
#  Scenario:
#    Given Rami-Levy home page
#    When Click Login
#    And Enter 'mahermorsi@gmail.com' and '12345678' in popup
#    And Click Login in popup
#    Then validate logged in

Feature: Login

  Background:
    Given a logged-in user with credentials 'mahermorsi@gmail.com' and '12345678'

  Scenario: User logs in
    Then validate logged in
