Feature:Login Functionality

  Background:
    Given Navigate to main page
    And Select Country
      | Turkey |
    And Hover on the element
      | myAccount |
    And Click on the element
      | logIn |

  @SmokeTest
  Scenario: Click Login without any information
    And Click on the element
      | logInBtn |
    Then Message or element should be seen
      | notificationMessage | Lütfen geçerli bir e-posta adresi giriniz. |

  Scenario: Click Login with invalid username without password
    When Enter information from Excel
      | username | invalidEmail |
    And Click on the element
      | logInBtn |
    Then Message or element should be seen
      | notificationMessage | Lütfen şifrenizi giriniz. |

  @SmokeTest
  Scenario Outline: Click Login with invalid username and invalid password various combination.
    When Enter information from Excel
      | username | <email> |
      | password | <pass>  |
    And Click on the element
      | logInBtn |
    Then Message or element should be seen
      | notificationMessage | E-posta adresiniz ve/veya şifreniz hatalı. |
    Examples:
      | email        | pass            |
      | invalidEmail | invalidPassword |
      | invalidEmail | Password        |
      | Email        | invalidPassword |

  @SmokeTest
  Scenario: Click Login with valid username and password
    When Enter information from Excel
      | username | Email |
      | password | Password  |
    And Click on the element
      | logInBtn |
    Then Message or element should be seen
      | myAccountAfterLogin | Hesabım |
