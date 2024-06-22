Feature: Createnewreport

  @Smoke
  Scenario: User creates a report
    Given the email and password field is open by click on the login option
    When the user is logged in with the following credentials
      | email    | hestabitt@gmail.com |
      | password | Pa$$w0rd!           |
    When the user click on the sigin button
    Then the user should navigate to the dashboard page
    When the user clicks on the create new report option
    Then the user should redirected to the creating report page
    And after creating report the user should redirected to the template page
    When the user enters enters the report name and report prompt
    Then report should be generated
    When the report is generated user use the functionality next previous and pagination on it
    And if the functionality work
    Then user click on the save option and after saving the file
    When the user clicks on the back to dashboard
    Then the user should be redirected to the dashboard
