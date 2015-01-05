Scenario: All added persons should display in database
Given the user is on the test page
When user add people to database:
|First Name|Last Name|Category|Gender|
|Bob|Sinclar|Movie|Male|
|Arnold|Schwarzenegger|Politics|male|
|John|Pes|sport|male|
|Metty|Jiu|sport|male|
Then following persons should display in database:
|First Name|Last Name|Category|Gender|
|Bob|Sinclar|Movie|Male|
|Arnold|Schwarzenegger|Politics|male|

Scenario: Creating person with first and last name
Given the user is on the test page
When user enter first name 'John'
When user enter last name 'Biber'
When user click button 'Add'
Then vip count should be '1'

Scenario: Creating several persons with first and last name
Given the user is on the test page
When user create persons:
|First Name|Last Name|
|Larry|Page|
|Garry|Douw|
|Gommer|Simpson|
|Bart|Simpson|
Then vip count should be '4'

Scenario: Creating person with empty first name
Given the user is on the test page
When user enter first name ''
When user click button 'Add'
Then should be popup with message: 'Please specify 'First Name' value'
Then close popup

Scenario: Creating person with empty last name
Given the user is on the test page
When user enter first name 'Bob'
When user enter last name ''
When user click button 'Add'
Then should be popup with message: 'Please specify 'Last Name' value'
Then close popup