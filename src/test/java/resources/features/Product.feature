Feature: Products Store
  Scenario: Get all products in store
    Given have more than 3 products in store
    And one of these products is a "Notebook"
    Then All products should be returned

  Scenario: Get one product in store
    Given have more than 0 products in store
    And one of these products is a "CellPhone"
    Then one product should be returned

  Scenario: Get one product in store when product doesn't exist
    Given have more than 0 products in store
    And none of these products is a "NonExistentProduct"
    Then should be throw an error