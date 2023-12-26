Feature: Test personal information

  Background:
    Given I am in Rami-Levy home page
    And Click Login
    And Enter 'mahermorsi@gmail.com' and '12345678' in popup
    And Click Login in popup
    And I'm navigated to 'https://www.rami-levy.co.il/he/dashboard'

    Scenario:
      When I send API request to change my personal information
      |    first_name     |    last_name     |    phone      |    sex_id     |    birthday_date     |
      |       Tzahi       |    Andigar       |  052-5435043  |      1        |    1980-10-10       |
      Then Validate name is updated to 'Tzahi'
      And last name is updated to 'Andigar'