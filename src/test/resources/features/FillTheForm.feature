Feature: user feel te form

  @form
  Scenario Outline: user should be able to place order and order should be seen in page
    Given user is already logged in and navigated to order page
    When user selects product type "FamilyAlbum"
    And user enters quantity  "<quantity>"
    And user enters customer "<name>"
    And user enters street  "<street>"
    And user enters city  "<city>"
    And user enters state  "<state>"
    And user enters zip "<zip>"
    And user selects credit card type "American Express"
    And user enters credit "<car number>"
    And user enters xp num "<expiration date>"
    And user enters process order button
    Then user should see "New order has been successfully added." in the first row of the table
    Examples:
      | quantity | name         | street           | city     | state    | zip   | car number       | expiration date |
      | 2       | Chuck Norris | 1100  Long way dr | Charlore | Virginia | 22011 | 1111222233334444 | 12/25           |