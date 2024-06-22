Feature: LoginAccount

  @Smoke @Sanity
  Scenario: Succesfull LoginAccount
    Given the user navigates to webpagemarketguru
    When the user click on the login option
    Then in the login page the email password field should shown
    When the user enters the below detils in the field and click on the login field
      | Email    | hestabitt@gmail.com |
      | Password | Pa$$w0rd!           |
    Then the user successfully login message should shown
