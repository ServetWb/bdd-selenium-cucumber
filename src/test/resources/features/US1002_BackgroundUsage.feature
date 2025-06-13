Feature: US1002 User defines common starting steps using Background

  Background: Navigate to homepage
    Given user goes to the Test Automation homepage

  Scenario: TC04 User should see results when searching for "phone"
    When user searches for phone in the search box
    Then verifies that products are found in the search results
    And closes the page

  Scenario: TC05 User should see results when searching for "dress"
    When user searches for dress in the search box
    Then verifies that products are found in the search results
    And closes the page

  Scenario: TC06 User should see no results when searching for "Java"
    When user searches for Java in the search box
    Then verifies that no products are found in the search results
    And closes the page