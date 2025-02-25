Feature: Add a smartphone to the cart

  Scenario: Verify that the start price and instalment amount of the product is the same on the product page and cart page,and that the quantity of products in the cart is visible on the landing page
    Given T-Mobile landing page is open
    When Go to smartphones
    And Open a device
    And Add a device to the cart
    Then The price and instalment values on the cart page are the same as on the device page
    And The quantity of products in the cart is displayed next to the cart icon on the landing page
