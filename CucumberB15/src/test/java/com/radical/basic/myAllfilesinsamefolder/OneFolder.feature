Feature: facebook login
As a fb user, I want to enter username and pwd as a parameter

Scenario: validate fb login Scenario1
Given the user is on facebook login Page
When he enters "anil" as user name
And he enters "pwd" as password
Then check username is present in textbox
