Feature: User enter many data

  Scenario: user enter pass multiple data
    Given  user on google page
    Then user enter data
      | Kyiv   |
      | Baku   |
      | Dallas |
      | Home   |


  Scenario Outline: user enter pass multiple data
    Given  user on google page
    Then user search "<Country>"
    Then user search  for "<Capital>"
    Examples:
      | Country | Capital |
      | Azerbaijan | Baku    |
      | Ukraine    | Kyiv    |





