Scenario: Button 'Disconnect' testing
Given the user is on the test page
When user press button Disconnect
Then state of database should be 'Offline'

Scenario: Button 'Connect' testing
Given the user is on the test page
When user press button Disconnect
Then state of database should be 'Offline'
When user press button Connect
Then should be popup with message 'Connect to Database?'
When user press button 'OK' in popup
Then state of database should be 'Online'