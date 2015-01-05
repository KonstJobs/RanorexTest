Scenario: Button 'Load' testing 1
Given the user is on the test page
When user click button 'Load'
Then person with 'First Name' 'Sylvester' should display in database
Then person with 'Last Name' 'Stallone' should display in database

Scenario: Button 'Load' testing 2
Given the user is on the test page
When user click button 'Load'
Then people should display in database:
|First Name|Last Name|Category|Gender|
|Sylvester|Stallone|Movie|Male|
|Elvis|Presley|Music|Male|
|Marie|Curie|Science|Female|
|Andre|Agassi|Sport|Male|
|Arnold|Schwarzenegger|Politics|Male|
|Marilyn|Monroe|Other|Female|
Then vip count should be '6'

Scenario: Button 'Load' testing 3
Given the user is on the test page
When user add person:
|First Name|Last Name|
|Bob|Spanch|
When user click button 'Load'
Then people should display in database:
|First Name|Last Name|Category|Gender|
|Sylvester|Stallone|Movie|Male|
|Elvis|Presley|Music|Male|
|Marie|Curie|Science|Female|
|Andre|Agassi|Sport|Male|
|Arnold|Schwarzenegger|Politics|Male|
|Marilyn|Monroe|Other|Female|
Then vip count should be '6'