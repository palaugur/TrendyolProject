Feature: Favorite Functionality

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

  Scenario: Adding product to Favorite List
    When Send keys to input in website
      | searchBox | gaming |
    And Click on the element in website
      | searchBtn |
    Then Verify searched products
      | gaming |
    When Add three product to favorite randomly from search result
    And Click on the element in website
      | myFavorites |
    Then Verify products in favorite list

  Scenario: Remove product from Favorite List
    When Click on the element in website
      | myFavorites |
    And Remove product from favorite list
    Then Verify deleted product from favorite List