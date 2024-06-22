Feature: Updating the profile info from the account setting options

  @smoke
  Scenario: User update the profile info through the account setting options
    Given the email and password field is open by clicking on the login option
    When the user is logged in with the following credentials
      | email    | hestabitt@gmail.com |
      | password | Pa$$w0rd!           |
    When the user click on the sigin option
    Then the user navigate to the dashboard page and the text should be matched
    When the user clicks on the accounts setting option then the dropdown should open
    Then the profile page should open after clicking on the profile option
    When the user clicks on the edit option
    Then the details edit should be allowed
    And when the user click on the update option then the changes should be updated
