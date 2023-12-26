Feature: Test on address Page

  Background:
    Given user logged in with credentials 'mahermorsi@gmail.com' and '12345678'
    And navigated to 'https://www.rami-levy.co.il/he/dashboard/addresses'

  Scenario Outline: Validate the added addresses are shown on the address page
    When I initialize an Address instance with the following fields: '<city_id>' '<city>' '<street>' '<street_number>' '<zip>' '<apartment>' '<floor>'
    And I send a POST request with the address instance json
    Then Verify the given address is added to the list of addresses

    Examples:
      | city_id | city     | street        | street_number | zip    | apartment | floor |
      | 1337    |   עכברה  |     12        |      12       |    12  |    12     |  12   |
      | 1246    |  עכו     | עיר עתיקה 12  |      12       | 2471615|   12      | 12    |

  Scenario: Validate the cart has one address, after adding the same address twice, and removing it once
    When I add the same address twice
      | 1337    |   עכברה  |     12        |      12       |    12  |    12     |  12   |
    And I remove the same address once
    Then Validate the address list contains one address

