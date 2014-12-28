
Scenario: Adding new person
Given the user is on the Test page
When user add person with name 'John'
When enter second name 'Gendalf'
When press button 'Add'
Then vip count должно быть нахуй '1'

Scenario: Adding two new persons
Given the user is on the Test page
When user add person with name '1234'
When enter second name '1234'
When press button 'Add'

When user add person with name 'asdf'
When enter second name 'sdfds'
When press button 'Add'

Then vip count должно быть нахуй '65'

