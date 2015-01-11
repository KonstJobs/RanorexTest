Narrative:
User can load vips from database by button 'Load'

Scenario: Button 'Load' should loads 6 vips from database
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

Scenario: Vips that have been downloaded via button 'Load'
shouldn't delete previous vips in database
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
Then vip count should be '7'