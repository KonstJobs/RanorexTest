Narrative:
This test suite check vips loading to database
depending on the sate of database

Scenario: Button 'Disconnect' testing
Given the user is on the test page
When user press button Disconnect
Then state of database should be 'Offline'
Then button 'Load' should be disabled
And button 'Save' should be disabled
And button 'Clear' should be enabled

Scenario: Button 'Connect' testing
Given the user is on the test page
When user press button Disconnect
Then state of database should be 'Offline'
When user press button Connect
Then should be popup with message: 'Connect to Database?'
When user press button 'OK' in popup
Then state of database should be 'Online'
Then button 'Load' should be enabled
And button 'Save' should be enabled
And button 'Clear' should be enabled

Scenario: User can't add person when sate of database is 'offline'
Given the user is on the test page
When user press button Disconnect
Then state of database should be 'Offline'
When user add person:
|First Name|Last Name|
|Bob|Spanch|
Then vip count should be '0'