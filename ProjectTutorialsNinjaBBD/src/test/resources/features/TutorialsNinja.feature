Feature: PHPTravels Automation

Background:
	Given user launches browser

@Smoke
Scenario: Validate User Registration
	When user enters registration details
	Then validate registration successfully


@Smoke @Regression
Scenario Outline: Validate Login Functionality
	When user enters <username> and <password>
	Then validate login result
	
Examples:
| username            | password |
| user@phptravels.com | demouser |
| invalid@gmail.com   | invalid  |
|                     | demouser |
| user@phptravels.com |          |

@Regression
Scenario: Validate Hotel Search
	When user searches hotel details
	Then validate hotel search result

@Smoke @Regression
Scenario: Validate Complete Booking Workflow
	When user completes booking
	Then validate booking confirmation