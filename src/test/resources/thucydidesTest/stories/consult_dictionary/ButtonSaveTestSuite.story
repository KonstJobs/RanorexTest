Scenario: Button 'Save' testing3
Given the user is on the test page
When user click button 'Save'
Then should be popup with message '0 VIP(s) stored sucessfully'

Scenario: Button 'Save' testing2
Given the user is on the test page
When user add persons with category and gender
|firstName|lastName|category|gender|
|alskdf|sfdsd|Movie|Male|
When user click button 'Save'
Then should be popup with message '1 VIP(s) stored sucessfully'

Scenario: Button 'Save' testing
Given the user is on the test page
When user add persons with category and gender
|firstName|lastName|category|gender|
|Sylvester|Stallone|Movie|Male|
|Andre|Agassi|sport|male|
|Arnold|Schwarzenegger|politics|male|
|Marilyn|Monroe|other|female|
When user click button 'Save'
Then should be popup with message '4 VIP(s) stored sucessfully'

Scenario: Button 'Save' testing with count persons
Given the user is on the test page
When user add persons 5 times with category and gender
|firstName|lastName|category|gender|
|Sylvester|Stallone|Movie|Male|
|Andre|Agassi|sport|male|
Then vip count should be '10'



