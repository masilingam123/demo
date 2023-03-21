
Feature: Verify the API for practise

Scenario: verify first name and last name
Given visiting the API
When get response from API
Then validate the response code
Then verify series

Scenario: verify circuitID and circuitName and locality
Given visiting the API2
When get response from API2
Then validate the response code2
Then verify circuitID
And verify the circuitName
Then verify the locality

Scenario: verify url and season
Given visiting the API3
When get response from API3
Then validate the response code3
And verify url
Then verify season

Scenario: print the responce
Given visiting the API4
When get response from API4
Then print the responce in console

Scenario: print targeted API response using examples
Given visiting the targeted API "<url>"  "<target>"
When get targeted response from API
Then print the targeted responce in console
Examples: 
|url| target |
|https://ergast.com/api/f1/2017/circuits| /americas|


Scenario: trying put option	
Given hitting the API with payload
When store the response

Scenario: Trying to post option
Given hitting the post with payload
Then Store the post response
Then verify the response

@tag
Scenario: trying delete option
Given trying to hit delete API with payload
Then strore delete response
Then verify the delete response

@tag1
Scenario: trying delete option
Given trying to hit delete API with payload
Then strore delete response
Then verify the delete response
@tag2
Scenario: Title of your scenario
Given Get and print API response
When get the responce
Then validate the outcomes
@rr
Scenario: book verify
Given visit the page
When get the book
Then print the value of the book

Scenario: 