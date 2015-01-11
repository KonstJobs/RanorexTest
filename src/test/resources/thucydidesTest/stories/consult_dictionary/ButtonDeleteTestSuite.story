Narrative:
Button 'Delete' should delete selected person in the database

Scenario: Selected person should be removed from database
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

Scenario: User can delete all the people from data base
clicking button 'Delete'
Given the user is on the test page
When user click button 'Load'
Then vip count should be '6'
Then number of people in the database should be '6'
When user press button 'Delete' 6 times
Then vip count should be '0'
Then number of people in the database should be '0'