Scenario: All added persons should display in database
Given the user is on the test page
When user add persons with category and gender:
|First Name|Last Name|Category|Gender|
|Bob|Sinclar|Movie|Male|
|sdf|sdfs|sport|male|
|John|Pes|sport|male|
|Metty|Jiu|sport|male|
Then following persons should display in database:
|First Name|Last Name|Category|Gender|
|Bob|Sinclar|Movie|Male|
|sdf|sdf|sport|male|