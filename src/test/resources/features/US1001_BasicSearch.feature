Feature: US1001 User searches for products on Test Automation site

  Scenario: TC01 User should see results when searching for "phone"

    Given user goes to the Test Automation homepage
    When user searches for phone in the search box
    Then verifies that products are found in the search results
    And closes the page

  Scenario: TC02 User should see results when searching for "dress"

    Given user goes to the Test Automation homepage
    When user searches for dress in the search box
    Then verifies that products are found in the search results
    And closes the page

  Scenario: TC03 User should see no results when searching for "Java"

    Given user goes to the Test Automation homepage
    When user searches for Java in the search box
    Then verifies that no products are found in the search results
    And closes the page