Feature: Add a product to the cart

  Scenario: Select a smartphone from the list of offers
    Given The landing page is open
    When Add a smartphone to the cart
    Then The smartphone is added to the cart and the price and instalment are correct
