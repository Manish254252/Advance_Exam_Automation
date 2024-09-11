Feature: SauceLabs testing

  Scenario: Verify user can Login
    Given user opens application
    Then verify user is on Login Screen
    When user enters "username" as username
    And user enters "password" as password
    When user clicks on login
    Then verify user is on homeScreen


