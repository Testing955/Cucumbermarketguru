Feature: ForgetPassword

  @Smoke
  Scenario: Sucessful ForgetPassword
    Given the user navigates to webpage
    When the user click on the login link
    Then in the login page,forgot password option should shown
    When the user click on the forgot password? option
    Then the email field page should open
    When the user click on the send link option
    Then a success message should be displayed
