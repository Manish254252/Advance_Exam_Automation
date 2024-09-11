Feature: SauceLabs testing

  Scenario: Verify user can Login
    Given user opens application
    Then verify user is on Login Screen
    When user enters "username" as username
    And user enters "password" as password
    And print descriptions
    When user clicks on login
    Then verify user is on homeScreen


  Scenario: Verify user can View product on HomeScreen
    Given user opens application
    Then verify user is on Login Screen
    When user enters "username" as username
    And user enters "password" as password
    When user clicks on login
    Then verify user is on homeScreen
    And print products from homescreen

  Scenario: Verify user can Checkout
    Given user opens application
    Then verify user is on Login Screen
    When user enters "username" as username
    And user enters "password" as password
    When user clicks on login
    Then verify user is on homeScreen
    Given user adds product to cart
    When  user clicks on addToCartLogo
    Then verify user is on cartScreen
    And User clicks on checkout
    And user fills information
    And user clicks on continue
    And user clicks on Finish

  Scenario: Drawing
    Given user opens application
    Then verify user is on Login Screen
    When user enters "username" as username
    And user enters "password" as password
    When user clicks on login
    Given Drawing

  Scenario: webview
    Given user opens application
    And verify user is on Login Screen
    When user enters "username" as username
    And user enters "password" as password
    When user clicks on login
    And  click on hamburger
    And  click on webview
    Then enter url as "https://www.google.com"
    And click on goto button



  Scenario: sorting
    Given user opens application
    Then verify user is on Login Screen
    When user enters "username" as username
    And user enters "password" as password
    When user clicks on login
    And user clicks on sorting by price high to low
    Then verify sorting is working

  Scenario: Verify user can double click
    Given user opens application
    Then verify user is on Login Screen
    When user enters "username" as username
    And user enters "password" as password
    When user clicks on login
    Then verify user is on homeScreen
    Given user adds product to cart with doubleTap
