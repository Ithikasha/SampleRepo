@Regression
Feature: Feature to test login functionality

  Scenario: Validate whether user able to reach login page
    Given I am on homepage
    When I click Login button in homepage
    Then I should see login page

  Scenario: Validate whether user able to to login with valid credentials
    Given I am on homepage
    When I click Login button in homepage
    And I enter valid username and password
    Then I should see user able to login with valid credentials
