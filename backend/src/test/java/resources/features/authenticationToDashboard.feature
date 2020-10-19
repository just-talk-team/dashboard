#HU31
Feature: Authenticate to use Dashboard
  Scenario: Login failed
    When introduce "user" and "password"
    Then receives status code of 400

  Scenario: Login passed
    When introduce "user" and "password"
    Then receives status code of 200

  Scenario: Login empty
    When introduce "user" and "password"
    Then receives status code of 400