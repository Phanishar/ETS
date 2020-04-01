Feature: To Validate Login successfull For ETS Trade Browser
@Automation @tc-01
Scenario Outline: Login For Single SignIn/Multiple SignIn/Default Adavnce option with product ST-FIX
Given User enters Credentials to LogIn
  | Username   | Password |
  | <username> | <password> |   
  
Examples:
	| username | password |
  | phani@epsiloncs.com | ep$!l0nC |
  | phani@epsiloncs.com | ep$!l0nC |
  | phani@epsiloncs.com | ep$!l0nC |
  | phani@epsiloncs.com | ep$!l0nC |

 
  