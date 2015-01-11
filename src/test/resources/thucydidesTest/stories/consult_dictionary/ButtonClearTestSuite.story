Narrative:
User can remove all the people form datadase

Scenario: All people should be removed from the database
if they have been added by button 'Add'
Given the user is on the test page
When user add people to database:
|First Name|Last Name|Category|Gender|
|Bob|Sinclar|Movie|Male|
Then vip count should be '1'
Then number of people in the database should be '1'
When user press button 'Clear'
Then vip count should be '0'
Then number of people in the database should be '0'

Scenario: All people should be removed from the database
if they have been added by button 'Load'
Given the user is on the test page
When user press button 'Load'
Then vip count should be '6'
Then number of people in the database should be '6'
When user press button 'Clear'
Then vip count should be '0'
Then number of people in the database should be '0'