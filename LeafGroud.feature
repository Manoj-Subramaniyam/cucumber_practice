
Feature: Validate LeafGround

Scenario: Click and Confirm new Window Opens
		Given Launch an chrome Browser
		When Load the url 'https://www.leafground.com'
		And Click on the window page in Main Menu
		And Click on the open button
		Then Confirm New window launched
		
Scenario: Click and Confirm Element is Visible on Waits
		Given Launch an chrome Browser
		When Load the url 'https://www.leafground.com'
		And Click on the wait page in Main Menu
		And Click on the button
		Then Confirm the element is visible