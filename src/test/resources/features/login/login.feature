Feature: Login into the application myStore

  Scenario: Successful login
    Given Krif is on the login page
    When he sends their valid credentials
    Then he should have access to manage his account

  Scenario: Remember things
    Given Pepito wants to remember something
    When he tries to remember Foo
    Then he should get Foo