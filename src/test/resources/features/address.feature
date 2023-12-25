Feature: address page
  Background:
    Given  logged in
    And navigate to address page

    Scenario: check added address
      When add the following addresses:
        | Name      | CityId | City      | Street    | StreetNumber | ZipCode | Apartment | Entrance       | Floor |
        | John Doe  | 1      | New York  | Broadway  | 123          | 10001   | Apt 101   | Main entrance  | 2nd   |
        | Jane Smith| 2      | San Fran  | Market St | 456          | 94105   | Apt 202   | Side entrance  | 3rd   |
      Then validate "addressID" added

    Scenario: delete address
      When add "addressID"
      And delete "addressID"
      Then validate "addressID" deleted
