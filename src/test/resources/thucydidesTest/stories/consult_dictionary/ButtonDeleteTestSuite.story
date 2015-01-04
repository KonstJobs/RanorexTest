Scenario: Button 'Delete' testing1
Given the user is on the test page
When user add persons with category and gender:
|First Name|Last Name|Category|Gender|
|Sylvester|Stallone|Movie|Male|
|Andre|Agassi|sport|male|
|Arnold|Schwarzenegger|politics|male|
|Marilyn|Monroe|other|female|
When user click button 'Delete'
Then count persons on the page should be '3'
Then vip count should be '3'

Scenario: Button 'Delete' testing2
Given the user is on the test page
When user add persons with category and gender:
|First Name|Last Name|Category|Gender|
|Sylvester|Stallone|Movie|Male|
When user click button 'Delete'
Then count persons on the page should be '0'
Then vip count should be '0'