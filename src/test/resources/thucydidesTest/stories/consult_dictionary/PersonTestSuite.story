Scenario: Creating several persons with category and gender
Given the user is on the test page
When user add persons with category and gender:
|firstName|lastName|category|gender|
|Bob|Sinclar|Movie|Male|
|sdf|sdfs|sport|male|
|John|Pes|sport|male|
|Metty|Jiu|sport|male|
Then vip count should be '4'
Then person with 'Last Name' 'Kozel' should display in database

