Feature: Application Login

#Hybrid scenarios (both web and mobile testing are included)
#Dont use background , use Hooks 
#Background:
#Given browser is selected by user
#When browser is triggered
#Then check if browser is started

@MobileTest
Scenario: Home page default login
Given User is on landing Page
When User login into the application with username as "Jon" and password as "Dany101"
Then Home Page is populated
And Cards are displayed

@SmokeTest @RegressionTest
Scenario: Home page default login
Given User is on landing Page
When User login into the application with username as "Jhon" and password as "Lily101"
Then Home Page is populated
And Cards are not displayed

@MobileTest
Scenario: Home page Signup
Given User is on landing Page
When User sign up with following details
| Hannibal | Lecter | hlecter@dark.com | Atlanta | 603-34598746 |
Then Home Page is populated
And User is registered for the services

@RegressionTest
Scenario Outline: Home page login
Given User is on landing Page
When User login with <Username> and <Password>
Then Home Page is populated
And Cards are displayed

Examples: Login Details
|Username |Password |
|Jon      |dany101  |
|Jonas    |Martha33 |
|Avinav   |Autumn21 |
|Chandler |Monica26 |