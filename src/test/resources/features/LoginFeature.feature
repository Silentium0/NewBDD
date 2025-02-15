Feature:  Docuport LogIn feature


  @test1
  Scenario: login as a client
    Given user on Docuport login page page
    When user enter username
    When user enter password
    When user click login button
    When user should see home page