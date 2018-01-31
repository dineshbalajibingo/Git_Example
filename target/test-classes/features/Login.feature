Feature: Test Login Page of 53 Bank

@tag1
Scenario: Testing Login Page with one user name and password
Given Open browser and hit url
	And I click on main login button
	And I enter user name as "test"
	And I enter password as "testing"
	And I click on login button
	Then I validate error message

