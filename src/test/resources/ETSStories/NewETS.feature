Feature: To Validate TradeCapture - Advance option Product

  @Automation @tc-01
  Scenario: End2End Test for ETS/Trade capture/Advance Product workflow
    Given I enter the URL as"https://ets-dev.epsiloncs.net"
    When I enter username as "raghu"
    And I enter password as "ep$!l0nC$"
    Then I click on login button
    Then I click on "TradeCapture" menu
    Then I click on "Advance" option
    Then I validate new pop window with "Untitled|Draft" title is displayed
    Then I click 'Product' DropDown under "KeyAttributes"
    Then I select 'ST-FIX' from 'Product' dropdown under "KeyAttributes"
    Then I click on 'Member' DropDown under "KeyAttributes"
    Then I select BANK OF NY from 'Member' dropdown under "KeyAttributes"
    When I right click under "TradingEvents" section
    Then I click on +Add option
    Then I select 'CASH' from 'TypeOfMoney' dropdown under "Tags"
    Then I enter '50000' in 'NewMoneyAmount' text box under "Tags"
    Then I click on "Wired"
    Then I enter '1000' in 'WiredAmount' text box under "Tags"
    Then I click on "OUT" radio button under 'Wired'
    Then I enter "05/17/2018" in 'ValuationDate' text box under "Analytics"
    When I click on "CALCULATE" button
    Then I validate new row appears under "Analytics"
    When I click on 'Save' under "Dots" menu
    Then I validate status as "DRAFT"
    When I click on 'Execute' under Dots menu
    Then I validate status as "DONE"
    When I click on 'ConfirmWMember' under "Dots" menu
    Then I validate status as "CONFIRMED"
    When I click on chat button
    Then I enter 'HI' in chatbox
    Then I Click On Send button
    Then I Validate text
    Then I click close button
    When I Click File button
    Then I right click under "Documents"
    Then I click Add option

  @Automation @tc-02
  Scenario: End2End Test for ETS/Trade capture/Advance Product workflow / Fail
    Given I enter the URL as"https://ets-dev.epsiloncs.net"
    When I enter username as "raghu"
    And I enter password as "ep$!l0nC$"
    Then I click on login button
    Then I click on "TradeCapture" menu
    Then I click on "Advance" option
    Then I validate new pop window with "Untitled|Draft" title is displayed
    Then I click 'Product' DropDown under "KeyAttributes"
    Then I select 'ST-FIX' from 'Product' dropdown under "KeyAttributes"
    Then I click on 'Member' DropDown under "KeyAttributes"
    Then I select BANK OF NY from 'Member' dropdown under "KeyAttributes"
    When I right click under "TradingEvents" section
    Then I click on +Add option
    Then I select 'CASH' from 'TypeOfMoney' dropdown under "Tags"
    Then I enter '50000' in 'NewMoneyAmount' text box under "Tags"
    Then I click on "Wired"
    Then I enter '1000' in 'WiredAmount' text box under "Tags"
    Then I enter "05/17/2018" in 'ValuationDate' text box under "Analytics"
    When I click on "CALCULATE" button
    Then I validate new row appears under "Analytics"
    When I click on 'Save' under "Dots" menu
    Then I validate status as "DRAFT"
    When I click on 'Execute' under Dots menu
    Then I validate status as "DONE1"
    When I click on 'ConfirmWMember' under "Dots" menu
    Then I validate status as "CONFIRMED"
    When I click on chat button
    Then I enter 'HI' in chatbox
    Then I Click On Send button
    Then I Validate text
    Then I click close button
    When I Click File button
    Then I right click under "Documents"
    Then I click Add option
