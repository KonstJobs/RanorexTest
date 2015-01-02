Scenario: Testing assertion persons
Given the user is on the test page
When user click 'Load'
Then vip count should be '6'
Then state of database should be 'Online'

