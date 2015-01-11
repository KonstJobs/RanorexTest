Narrative:
This test suite tests fields on the page First Name, Last Name and button 'Add'

Scenario: Adding person with first and last name
Given the user is on the test page
When user enter first name 'John'
When user enter last name 'White'
When user click button 'Add'
Then vip count should be '1'
Then person with 'First Name' 'John' should display in database
Then person with 'Last Name' 'White' should display in database

Scenario: All added persons should display in database
Given the user is on the test page
When user add people to database:
|First Name|Last Name|Category|Gender|
|Bob|Sinclar|Movie|Male|
|Arnold|Schwarzenegger|Politics|male|
|John|Pes|sport|male|
|Metty|Jiu|sport|male|
Then people should display in database:
|First Name|Last Name|Category|Gender|
|Bob|Sinclar|Movie|Male|
|Arnold|Schwarzenegger|Politics|male|
|John|Pes|sport|male|
|Metty|Jiu|sport|male|
Then vip count should be '4'

Scenario: Adding several people with first and last name
Given the user is on the test page
When user add people:
|First Name|Last Name|
|Larry|Page|
|Garry|Douw|
|Gommer|Simpson|
|Bart|Simpson|
Then vip count should be '4'

Scenario: Adding person with empty first name
Given the user is on the test page
When user enter first name ''
When user click button 'Add'
Then should be popup with message: 'Please specify 'First Name' value'
Then popup is closed

Scenario: Adding person with empty last name
Given the user is on the test page
When user enter first name 'Bob'
When user enter last name ''
When user click button 'Add'
Then should be popup with message: 'Please specify 'Last Name' value'
Then popup is closed

Scenario: Adding person with empty first and last name
Given the user is on the test page
When user enter first name ''
When user enter last name ''
When user click button 'Add'
Then should be popup with message: 'Please specify 'First Name' value'
Then popup is closed

Scenario: Adding person with long first and last name
Given the user is on the test page
When user enter first name 'veeeeeryyyyy looooooooooooong first naaaaaaaaaaameeeeeeeeee'
When user enter last name 'veeeeeryyyyy looooooooooooong last naaaaaaaaaaameeeeeeeeee'
When user click button 'Add'
Then position of database on the page should be the same