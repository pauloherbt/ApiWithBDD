Feature: Products Store
  Scenario: Get all products in store
    Given have more than 3 products in store
    And one of these products is a Notebook
    Then All products should be returned