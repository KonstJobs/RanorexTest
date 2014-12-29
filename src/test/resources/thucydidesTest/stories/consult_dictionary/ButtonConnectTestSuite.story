Scenario: Button 'Disconnect' testing
Given the user is on the test page
When user press button Disconnect
Then state of database should be 'offline'

Scenario: Button 'Connect' testing
Given the user is on the test page
When user press button Disconnect
Then state of database should be 'offline'
When user press button Connect
Then should be popup with message 'Connect to Database?'

