Feature: MoneyGaming Registration

Scenario Outline: Verify new user registration with valid data

	Given user on the registration page
	And user enters "<fname>" "<lname>" "<password>" "<reenterPassword>"
	When user click on JoinNow Button
	Then user should navigate to user's home page
	
Examples:
	|fname   	| lname 		| password		| reenterPassword	|
	|Tom		| Cruise		| #Tom12		| #Tom12			|
	|Jon		| Doe			| JonDoe@3		| JonDoe@3			|
	
	
Scenario Outline: Verify new user registration with invalid data

	Given user on the registration page
	And user enters "<fname>" "<lname>" "<password>" "<reenterPassword>"
	When user click on JoinNow Button
	Then user should see the registration unsuccessful
	
Examples:
	|fname   	| lname 		| password		| reenterPassword	|
	|Tom		| Cruise		| 12345			| 12345				|
	|Tom		| Cruise		| 123456		| 123456			|
	|Tom		| Cruise		| $1234			| $1234				|
	|Tom		| Cruise		| 1234%			| 1234%				|
	|Tom		| Cruise		| 				| 					|


