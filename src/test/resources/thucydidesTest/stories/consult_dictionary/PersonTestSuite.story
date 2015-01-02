Scenario: Creating several persons with category and gender
Given the user is on the test page
When user add persons with category and gender
|firstName|lastName|category|gender|
|alskdf|sfdsd|Movie|Male|
|sdfsd|dsfdsf|sport|male|
|sdfsd|dsfdsf|music|male|
|asdf|dsfdssdfdsfdf|music|male|
Then vip count should be '4'

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

