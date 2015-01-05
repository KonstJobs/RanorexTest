Scenario: Button 'Save' testing 1
Given the user is on the test page
When user click button 'Save'
Then should be popup with message: '0 VIP(s) stored sucessfully'
Then close popup

Scenario: Button 'Save' testing 2
Given the user is on the test page
When user add people to database:
|First Name|Last Name|Category|Gender|
|alskdf|sfdsd|Movie|Male|
When user click button 'Save'
Then should be popup with message: '1 VIP(s) stored sucessfully'
Then close popup

Scenario: Button 'Save' testing 3
Given the user is on the test page
When user add people '5' times to database:
|First Name|Last Name|Category|Gender|
|Sylvester|Stallone|Movie|Male|
|Andre|Agassi|sport|male|
When user click button 'Save'
Then should be popup with message: '10 VIP(s) stored sucessfully'
Then close popup