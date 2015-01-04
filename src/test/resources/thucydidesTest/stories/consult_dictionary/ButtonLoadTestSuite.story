Scenario: Button 'Load' testing1
Given the user is on the test page
When user click button 'Load'
Then vip count should be '6'
Then person with 'First Name' 'Sylvester' should display in database

Scenario: Button 'Load' testing2
Given the user is on the test page
When user click button 'Load'
Then following persons should display in database:
|First Name|Last Name|Category|Gender|
|Sylvester|Stallone|Movie|Male|
|Elvis|Presley|Music|Male|
|Marie|Curie|Science|Female|
