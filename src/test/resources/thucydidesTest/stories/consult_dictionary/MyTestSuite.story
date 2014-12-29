Scenario: Creating person only with first and last name
Given the user is on the test page
When user enter first name 'John'
When user enter last name 'Biber'
When user click button 'Add'
Then vip count should be '1'


Scenario: Creating several persons with first and last name
Given the user is on the test page
When user create persons
|firstName|lastName|
|Larry|Page|
|Garry|Douw|
|Gommer|Simpson|
|Bart|Simpson|
Then vip count should be '4'



Scenario: Creating several persons with category and gender
Given the user is on the test page
When user create persons with category and gender
|firstName|lastName|category|gender|
|Larry|page|music|male|
|Larry|page|movie|female|
|Larry|page|science|female|
|Larry|page|sport|male|
|Larry|page|politics|female|
Then vip count should be '5'


Scenario: Creating person with empty first name
Given the user is on the test page
When user enter first name ''
When user click button 'Add'
Then should be popup with message 'Please specify 'First Name' value'

Scenario: Creating person with empty last name
Given the user is on the test page
When user enter first name 'Bob'
When user enter last name ''
When user click button 'Add'
Then should be popup with message 'Please specify 'Last Name' value'