Feature: US1003 user searches for any desired keyword on the Test Automation page

  Scenario: TC07 user should be able to search for any keyword
    Given user goes to the Test Automation homepage
    When user searches for "samsung" in the search box
    And waits for 5 seconds for synchronization
    Then verifies that products are found in the search results
    And closes the page