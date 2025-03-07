Feature:  Docuport LogIn feature
  Background: run first of all
    Given user on Docuport login page page


  Scenario: login as a client
    When user enter username "b1g3_client@gmail.com"
    When user enter password "Group3"
    When user click login button
    When user click continue button
    When user should see "Home" page


  Scenario: login as a advisor
    When user enter username "b1g3_advisor@gmail.com"
    When user enter password "Group3"
    When user click login button
    When user should see "Home" page


  Scenario: login as a employee
    When user enter username "b1g3_employee@gmail.com"
    When user enter password "Group3"
    When user click login button
    When user should see "Home" page