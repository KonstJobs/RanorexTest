Scenario: Selected person should be removed from database (1)
Given the user is on the test page
When user click button 'Load'
Then vip count should be '6'
Then number of people in the database should be '6'
When user check person:
|First Name|Last Name|Category|Gender|
|Andre|Agassi|Sport|Male|
When user press button 'Delete'
Then vip count should be '5'
Then number of people in the database should be '5'

Scenario: Selected person should be removed from database (2)
Given the user is on the test page
When user click button 'Load'
Then vip count should be '6'
Then number of people in the database should be '6'
When user press button 'Delete' 6 times
Then vip count should be '0'
Then number of people in the database should be '0'