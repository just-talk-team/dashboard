#HU31
Feature: Authenticate to use Dashboard
  Scenario Outline: Login
    When introduce <user> and <password>
    Then receives status code of <status>
    Examples:
    |user     |password     |status |
    |"user"   |"password"   |400    |
    |"jose12" |"123456"     |400    |
    |""       |""           |400    |
