Feature: To Validate the Search option in Advance screen

  @Automation @tc-01
  Scenario: Validating Search button in Trade Capture/Advance
    Given User enters Credentials to LogIn
      | Username            | Password  |
      | phani@epsiloncs.com | ep$!l0nC$ |
    And user click on "TradeCapture" menu
    And user click on "Advance" option
    And user validate new pop window with "Untitled|Draft" title is displayed
    And user clicks 'Search button'
    And user enter "2020-01-03-0001" in "Search" textbox
    And user verify "Advance Date" with title
    And user enter with "product" details in Search button
    And user verify "Advance product" product with title
    And user click 'search button' to close

  @Automation @tc-02
  Scenario: Ability to use shortcuts in currency and date
    Then user clicks Key Attributes "Start Date"
    And user enter 'date' as "operations"
    And user verify 'date' in "Shortcuts"
    And user click "Currency text box"
    Then user enter shortcut "Currency value"
    Then user verify short cuts "currency value"

  @Automation @tc-03
  Scenario: Validate the workflow for Advance (DRAFT -> verified)
    Given User enters Credentials to LogIn
      | Username            | Password  |
      | phani@epsiloncs.com | ep$!l0nC$ |
    Then user click on "Trade Capture" options
    And user selects the "Advance" option
    Then user validate new pop window "Untitled/Draft" title is displayed
    Then user clicks on 'Product' DropDown under "KeyAttributes"
    Then user select 'ST-FIX' from 'Product' dropdown under "KeyAttributes"
    Then user select "Member" option
    Then user select 'BANK OF NY'from 'Member' dropdown under "KeyAttributes"
    When user right click under "TradingEvents" section
    Then user click on +Add option
    Then user enter "05/17/2018" in 'ValuationDate' text box under "Analytics"
    When user click on "CALCULATE" button
    Then user validate new row appears under "Analytics"
    When user click on 'Save' under "Dots" menu
    Then user validate status as "DRAFT"
    #And user verify the audit status as "V1"
    When user click on 'Execute' under "Dots" menu
    Then user validate status as "DONE"
    # And user verify the audit status as "V2"
    When user click on 'ConfirmWMember' under "Dots" menu
    Then user validate status as "CONFIRMED"
    #And user verify the audit status as "V3"
    And user clicks on 'verify'under "Dots" menu
    Then user validate status as "Verified"
    #And user verify the audit status as "V4"
    Then user click "chat" button
    And user enters some "text" words below "100"
    And user click "Attachement" option
    And user click "Send" options
    And user verify "notifications" in the above chatbox
    And user click "chat" button to close window
    
