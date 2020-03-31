Feature: To Validate Login successfull For ETS Trade Browser
@Automation @tc-01
Scenario: Login For Single SignIn/Multiple SignIn/Default Adavnce option with product ST-FIX

Given User launch the URL 
When User enters Credentials to LogIn
 | Username   | Password |
  | phani@epsiloncs.com | ep$!l0nC$ |

  Then user click on "TradeCapture" menu
  Then user click on "Advance" option
  Then user validate new pop window with "Untitled|Draft" title is displayed
  Then user click 'Product' DropDown under "KeyAttributes"
  Then user select 'ST-FIX' from 'Product' dropdown under "KeyAttributes"
  And user verify Startdate populated as "currentday"
  And user verify Enddate populated as "3"
  And user verify Amount populated as "1000"
  And user verify CCY Option as "USD"
  Then user verify 'Rate info index' Dropdown is populated as "Fixed"
Then user Verify 'Rate info Tenor option' Dropdown is populated as "Tenor"
Then user verify 'Rate info Actual Frequency' Dropdown is populated as "Monthly"
Then user verify 'Rate info Calendar option' Dropdown is populated as "NYC"
Then user verify 'Rate info Day Count' Dropdown is populated as "ACT/360"
Then user verify 'Rate Info Day' Dropdown is populated as "Day"
Then user verify 'payment Info Frequency' Dropdown is populated as "Monthly"
Then user verify 'payment info Calendar option' Dropdown is populated as "NYC"
Then user verify 'payment info Day' Dropdown is populated as "Day"
Then user verify 'payment info Roll Rule option' Dropdown is populated as "Backward"
Then user verify 'payment info Business day' Dropdown is populated as "Modified Following"
Then user verify 'payment info first payment' populated as "1"
Then user verify 'payment info Last payment' populated as "3"
Then user verify 'Analytics pricing Service'populated as "QuantLib"
Then user verify 'Analytics Cashflow From'populated as "Model Date"  
#Then user verify 'Analytics Valuation Date'populated as "currentday" 

