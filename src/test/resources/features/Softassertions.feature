Feature: soft Assertion

  @softAssertion
  Scenario: Soft Assertion Practise
    Given User login as "Client"
    Then user validate "Home"
    Then  after user validate "My uploads"
    Then user after validate "Invitations1"
    Then  and user validate "Received docs"
    Then validate All
