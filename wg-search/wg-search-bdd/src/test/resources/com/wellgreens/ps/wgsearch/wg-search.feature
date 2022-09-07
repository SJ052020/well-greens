Feature: We can retrieve items based on categories

  Scenario: We can retrieve all items for all configured categories
    When We request all categories
    Then Validate categories list with items
