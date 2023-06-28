Feature: Search Functionality

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

  Scenario Outline: Searching for the desired product
    When Send keys to input in website
      | searchBox | <Text> |
    And Click on the element in website
      | searchBtn |
    Then Verify searched products
      | <Text> |
    Examples:
      | Text    |
      | iphone  |
      | desktop |