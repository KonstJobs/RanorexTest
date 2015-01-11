Narrative:
Button 'Save' allows user to save vips in the database

Scenario: Popup should be displayed after clicking button 'Save'
Given the user is on the test page
When user click button 'Save'
Then should be popup with message: '0 VIP(s) stored sucessfully'
Then popup is closed

Scenario: Popup should be displayed after clicking button 'Save'
with count of vips in the database
Given the user is on the test page
When user add people to database:
|First Name|Last Name|Category|Gender|
|alskdf|sfdsd|Movie|Male|
When user click button 'Save'
Then should be popup with message: '1 VIP(s) stored sucessfully'
Then popup is closed

Scenario: Popup should be displayed after clicking button 'Save'
with count of vips in the database, no matter how meny times
ueser click button 'Save'
Given the user is on the test page
When user add people '5' times to database:
|First Name|Last Name|Category|Gender|
|Sylvester|Stallone|Movie|Male|
|Andre|Agassi|sport|male|
When user click button 'Save'
Then should be popup with message: '10 VIP(s) stored sucessfully'
Then popup is closed