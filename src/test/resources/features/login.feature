Feature: login

  @task1
  Scenario: user login to Docuport
    Given User login with Map
      | username    | b1g3_client@gmail.com |
      | password    | Group3                |
      | loginButton |                       |
    Then  user click continue button
    Then user click "My uploads" than click "Search"
    Then validate text "There are no items to display."

  @task2
  Scenario: user login to Docuport
    Given User login with Map
      | username    | b1g3_client@gmail.com |
      | password    | Group3                |
      | loginButton |                       |
    Then  user click continue button
    Then user click "Invitations" than click "Search" send input field "Loop" than click sent than " Search " and validate "Your search returned no results. Make sure you search properly"





@task3
  Scenario: user login to Docuport
    Given User login with Map
      | username    | b1g3_client@gmail.com |
      | password    | Group3                |
      | loginButton |                       |
    Then  user click continue button
  Then user click "My uploads"
  Then user click "Upload documents"



