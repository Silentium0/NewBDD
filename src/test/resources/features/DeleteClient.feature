Feature: user delete client
  @deleteclient
  Scenario: user able to delete client in My uploads
    Given user on Docuport login page page
    When user enter username "b1g3_advisor@gmail.com"
    When user enter password "Group3"
    Then user click login button
    Then user click "My uploads"
    Then user click last checkbox
    Then press "Delete" button
    Then press button "Remove"

