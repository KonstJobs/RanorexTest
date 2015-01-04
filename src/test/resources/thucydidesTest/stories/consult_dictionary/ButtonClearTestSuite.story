Scenario: Button 'Clear' testing1
Given the user is on the test page
When user add persons with category and gender:
|First Name|Last Name|Category|Gender|
|Bob|Sinclar|Movie|Male|
|Boby|Sinclar|Movie|Male|
When user press button 'Clear'
Then vip count should be '0'
Then count persons on the page should be '0'