Feature: User enter many data

  @test2
  Scenario: user enter pass multiple data
    Given  user on google page
    Then user enter data
      | Kyiv   |
      | Baku   |
      | Dallas |
      | Home   |


  @test3
  Scenario Outline: user enter pass multiple data
    Given  user on google page
    Then user search "<Country>"
    Then user search  for "<Capital>"
    Examples:
      | Country | Capital |
      | Azerbaijan | Baku    |
      | Ukraine    | Kyiv    |





