Scenario: Button 'Save' testing3
Given the user is on the test page
When user add persons 5 times with category and gender
|firstName|lastName|category|gender|
|Sylvester|Stallone|Movie|Male|
|Andre|Agassi|sport|male|
Then vip count should be '10'