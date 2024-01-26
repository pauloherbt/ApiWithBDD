Feature: Products Store
  Scenario: Get all products in store
    Given have more than 3 products in store
    And one of these products is a "Notebook"
    Then All products should be returned

  Scenario Outline: Get one product in store
    Given have more than 0 products in store
    And one of these products is a "<existingProduct>"
    When trying to get product with name "<existingProduct>"
    Then one product should be returned
    Examples:
      | existingProduct |
      | CellPhone       |

  Scenario Outline: Get one product in store when product doesn't exist
    Given have more than 0 products in store
    And the product with name "<nonExistingProduct>" doesnt exist
    When trying to get product with name "<nonExistingProduct>"
    Then should be thrown an exception
    Examples:
      | nonExistingProduct |
      | Balao              |


