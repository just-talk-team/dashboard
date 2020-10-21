#HU31
Feature: Authenticate to use Dashboard
  Scenario: Login failed
    When introduce "user" and "password"
    Then receives status code of 400

  Scenario: Login passed
    When introduce "jose12" and "123456"
    Then receives status code of 200

  Scenario: Login empty
    When introduce "" and ""
    Then receives status code of 400