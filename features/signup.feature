Feature: Account Signup

  @Smoke
  Scenario: Successful Account Signup
    Given the user navigates to Signup Account page
    When the user enters the details into below fields
      | firstName | Prince |
      | lastName  | Gaurav |
     
    And the user click on the createaccount button
    Then the verification code should open
