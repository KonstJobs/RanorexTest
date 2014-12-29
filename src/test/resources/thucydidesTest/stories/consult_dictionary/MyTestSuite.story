Scenario: Adding def persons
Given the user is on the Test page
When user add default persons
|firstName|lastName|
|Larry|page|
|Garry|douw|
|Gommer|simpson|
|Bart|simpson|
Then vip count should be '4'

Scenario: Adding persons
Given the user is on the Test page
When user add persons
|firstName|lastName|category|gender|
|Larry|page|MUSIC|MALE|
|Garry|douw|MUSIC|MALE|
|Gommer|simpson|MUSIC|MALE|
|Bart|simpson|MUSIC|MALE|
Then vip count should be '4'




Scenario: Checking pop-up with empty field Last Name
Given the user is on the Test page
When user type first name 'Gomer'
When press button 'Add'
Then should be popup with message 'Please specify 'Last Name' value'

Scenario: Checking pop-up with empty field Fist Name
Given the user is on the Test page
When user enter last name 'Simpson'
When press button 'Add'
Then should be popup with message 'Please specify 'First Name' value'

Scenario: Adding person
Given the user is on the Test page
When user enter first name <firstname>
When user enter last name <lastname>
When press button 'Add'
Then vip count should be '2'



Scenario: Checking pop-up with empty fielsd
Given the user is on the Test page
When click button 'Add'
Then should be popup with message 'Please specify 'First Name' value'



