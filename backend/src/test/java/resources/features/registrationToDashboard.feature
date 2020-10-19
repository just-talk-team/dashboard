Feature: Registration to use Dashboard
  Scenario: Registration failed
    When introduce "user", "name", "password"
    Then the client receives status code of 400

  Scenario: Login passed
    When introduce "user", "name", "password"
    Then the client receives status code of 200

  Scenario: Registration failed, user already exists
    When introduce "user", "name", "password"
    Then the client receives status code of 400