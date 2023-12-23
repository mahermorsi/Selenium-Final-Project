Feature: NBA Player Stats

  Background:
    Given I navigated to 'https://www.nba.com/stats/players/traditional'

  Scenario Outline: Validate the first player name in list for each search result
    When I choose '<Season>'
    And I also choose '<Season_Type>'
    Then '<First_List_Player>' appears on the top of the list


    Examples:
      | Season  | Season_Type     | First_List_Player |
      | 2023-24 | Regular Season  | Joel Embiid       |
      | 2011-12 | Playoffs        | LeBron James      |
      | 2000-01 | Regular Season  | Allen Iverson     |

  Scenario: Verify top three player names when pressing on win button in Season 2022-23
    When I choose season '2022-23'
    And I click on Wins button in Player list
    Then Validate three top players are
      | Brook Lopez   |
      | Derrick White |
      | Jevon Carter  |

  Scenario: Validate sum of Wins and Losses for the first player on list
    When I retrieve the Wins counts of the first player
    And I retrieve the Losses counts of the first player
    And I sum up both Wins and Losses count for the first player
    Then The sum should be equal to GP(Games played) for the first player