Feature: Login To Amazon Application

Scenario Outline: User login to Amazon

Given User Navigate to the Application
When User Enter '<Username>' and '<Password>'
Then User Verify user account and Title of the page


Examples:
| Username | Password |
| aravindrayana22@gmail.com | Paaroli@1210 |
