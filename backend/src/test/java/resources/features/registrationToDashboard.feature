Feature: Registration to use Dashboard
  Scenario Outline: Registration
    When introduce <user>, <name>, <password>
    Then the client receives status code of <status>
    Examples:
    |user   |name |password   |status|
    |"user"|""    |"password" |400  |
    |"user"|"name"|"password" |200  |
    |"user"|"name"|"password" |400  |
