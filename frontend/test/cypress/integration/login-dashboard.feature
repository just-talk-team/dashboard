Feature: Authenticate to use Dashboard

     As administrator
     I want to be able to authenticate with my username and password
     To use the dashboard

     #Background: navigate to the login page
     # Given the user navigates in the 'login'

    @TC01
    Scenario: TC01 - User data and password correct
         Given the user that entered your username and password correctly
         When he clicks the button -Loggin-
         Then he will be shown the dashboard home screen

    @TC02
    Scenario: TC02 - Incorrect username and password
         Given the user enter the user value
         And the user enters password value
         When the user clicks the button -Loggin-
         Then a pop-up window is shown with an error message

        #Examples: '<test>'
        #        | test             | user     | password  | errorMessage                    |
        #        | WrongPassword    | vivieall | Test123!  | Incorrect username or password  |
        #        | WrongUser        | vivieal  | Test123   | Incorrect username or password  |

    @TC03
    Scenario: TC03 - Incorrect user or password data.
         Given the user enter the user value
         And the user enters password value
         When the user clicks the button -Loggin-
         Then a pop-up window is shown with an error message

        #Examples: '<test>'
        #    | test             | user       | password | errorMessage                                                   |
        #    | NoEmail          |            | Test123  | Verify that the username and / or password field are not empty |
        #    | NoPassword       | vivieall   |          | Verify that the username and / or password field are not empty |
        #    | NoEmail&Password |            |          | Verify that the username and / or password field are not empty |
