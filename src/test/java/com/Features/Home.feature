Feature: WebSite
@K
Scenario: Verify Search fratures
Given User should be on Homepage
When User enter search items
|Mobile|
|RemoteBike|
Then User click on Search icon And result page
@M
Scenario: Verify user regitration
Given User click on Create account button
When User Enter "<Your Name>" and "<Mobile number or email>" and "<Password>" and "<Re-enter password>"
Then User click on Continue button and User will be on home page

Examples: 
|Your Name|Mobile number or email|Password|Re-enter password|
|Mitesh SIngh|1234567890|Saicool123|Saicool123|
|Babu|1234567890|test123|test123|
