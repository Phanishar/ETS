Feature: To validate Advance screen in Trade capture
@Automation @tc-01
Scenario: Validating ST-FIX with Amortschedule

Given User launch the URL 
When User enters Credentials to LogIn
  | Username   | Password |
  | phani@epsiloncs.com | ep$!l0nC$ |
 Then user clicks on "Trade Capture" option
Then user select the "Advance" option
Then user validate new pop window with "Untitled/Draft" title 
Then user clicks 'Product' DropDown under "KeyAttributes"
Then user selects 'ST-FIX' from 'Product' dropdown under "KeyAttributes"  
Then user click  "Member"
And user select "Bank Of NY" option
Then user right click under "Tradingevents" section
Then user click "Add" option
Then user click on userinfo "icon" 
Then user verify "Amort Exercise schedule" screen is displayed
Then user click the Amort "Generate" Button
And user click "Notificationdate" Execrise schedule
And user enter some "10"
And user clicks "call/put" 
And user clicks "Holder" option
Then user clicks on "close" button
Then user verify new "confirmation window"is populated
And user click the "Yes" button
Then user verify "Amortexercise Schedule" Icon button Grey to Orange 
Then user click  "emenu" button 
And user selects "Pincolumn" under emenu button
And user click "PinToright" column
Then user click "Filter" button and click checkbox option
And user selects "single or multiple checkbox" in filter
And user verify Filtered option applicable
Then user click "Dots" button and selects "resetgridlayout" options
And user verify grid is rest with "columns" and "values"






 



 
