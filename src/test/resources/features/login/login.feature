Feature: Login into the application myStore

  Scenario: Successful login
    Given Krif is on the login page
    When he sends their valid credentials
    Then he should have access to manage his account