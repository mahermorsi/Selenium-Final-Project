Feature: Address Page

  Background:
    Given a logged-in user with credentials 'mahermorsi@gmail.com' and '12345678'
    And navigate to address page
    When add the following addresses:
      | Name         | CityId | City         | Street        | StreetNumber | ZipCode | Apartment | Entrance       | Floor |
      | מוהנד יזבכ  | 1      | נצרת         | ביר אלאמיר   | 1010        | 1649500 | 10        | Main entrance  | 2nd   |

  Scenario: Check added address
    Then validate address added

  Scenario: Check deleted address
    And delete added address