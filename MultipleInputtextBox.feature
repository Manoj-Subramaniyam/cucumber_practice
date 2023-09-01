Feature: Multiple input to TextBox

Background:
   Given Launch an chrome Browser
	 When Load the url "https://www.leafground.com"
	 
Scenario Outline: Enter values to TextBox

		When Click on the Text page in Main Menu
		And Enter the Values "<name>" and "<country>"
		Then Verify the values are entered
	Examples:
		| name | country|
		| vijay | India|
		|sethu|US|
		|pathi|rusiia|
