Feature: Facebook1 login validation with DataTableMap
As a fb user, I want to enter username and pwd with DataTableMap
Scenario: validate fb login page
Given the user is on facebook login Page
When he enters following data 
	| Labels                 | Params              | Params1  	|
	| First Name             | Jyoti               |  A				  |
	| Last Name              | Doiphode            |	B					|
	| Mobile                 | 9422322818     		 |	C					|
	| Email Address          | jyoti@gmail.com 		 |	D					|
	| Password               | Password1           |	E					|
	| Birthdate              | 23.10.1980          |	F					|
	| Gender								 | Female							 |  G					|
Then check signup should failed

