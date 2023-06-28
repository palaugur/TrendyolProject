Feature: Cart Functionality

  Background:
    Given Navigate to main page
    And Select Country
      | Turkey |
    And Hover on the element
      | myAccount |
    And Click on the element
      | logIn |

    When Enter information from Excel
      | username | Email    |
      | password | Password |
    And Click on the element
      | logInBtn |
    Then Message or element should be seen
      | myAccountAfterLogin | Hesabım |

  Scenario: Adding product to Cart
    When Send keys to input in website
      | searchBox | gaming |
    And Click on the element in website
      | searchBtn |
    Then Verify searched products
      | gaming |
    When Add three product to Cart randomly from search result
    And Click on the element in website
      | myCart |
    Then Verify products in Cart

  Scenario: Remove product from Cart
    When Click on the element in website
      | myCart |
    And Remove product from the cart
    When Click on the element in website
      | myCart |
    Then Verify deleted product from Cart
