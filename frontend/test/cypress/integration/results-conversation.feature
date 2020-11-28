Feature: Filter Conversation Results

     As administrator
     I want to be able to have a dashboard with information about finished conversations
     To be able to analyze them and be able to make change decisions.

    #Background: The user has logged in
    # Given the user navigates in the 'dashboard'

    @TC04
    Scenario: TC04 - Start Date and End Date entered correctly
         Given the user who has placed the mandatory values of -StartDate- and -EndDate-
         And optionally select some additional filter
         When he clicks on the button -Analyze-
         Then a dashboard will be shown with the requested information

    @TC05
     Scenario: TC05 - Start Date and / or End Date not indicated
         Given the user has not placed the mandatory values of -StartDate- and -EndDate-
         And select only one date -StartDate- or -EndDate-
         When he clicks on the button -Analyze-
         Then a pop-up window is shown with an error message

        #Examples: <test>
        #  | test           | StartDate   | EndDate   | errorMessage                                                                 |
        #  | EndDateEmpty   | 10/10/20    |           | You must choose a mandatory start and end date to continue with the analysis |
        #  | StartDateEmpty |             | 11/10/20  | You must choose a mandatory start and end date to continue with the analysis |

    @TC06
    Scenario: TC06 - Start Date and / or End Date entered incorrectly
         Given the user who has not yet set the mandatory values of -StartDate- and -EndDate-
         And select an -EndDate- less than -StartDate-
         When he clicks on the button -Analyze-
         Then a pop-up window is shown with an error message

        #Examples: <test>
        #   | test           | StartDate   | EndDate   | errorMessage                                      |
        #   | InvalidDate    | 10/10/20    | 09/10/20  | The start date must be less than the end date     |