Feature: Buy a Product
  Background:
    Given Customer open customer app

  Scenario: Customer buy a product
    Given Customer click "Sauce Lab Back Packs" product name
    When Customer click "Blue" product color
    And Customer click plus icon by 2 to increase quantity
    And Customer click Add to cart button
    And Customer click Shopping Cart button
    And Customer click Proceed to Checkout button
    And Customer login with "Test" username and "Test" password
    And Customer enter "Steven Halim " as Full Name
    And Customer enter "Madagascar St. at 420" as Address Line 1
    And Customer enter "London" as City
    And Customer enter "11460" as Zip Code
    And Customer enter "Italy" as Country
    And Customer click Payment button
    And Customer enter "Halim Steven" as Card Holder Full Name
    And Customer enter "4242424242424242" as Card Number
    And Customer enter "1234" as Expiration Date
    And Customer enter "123" as Security Code
    And Customer click Review Order button
    And Customer check order and click Place Order button
    Then Customer click Continue Shopping button


