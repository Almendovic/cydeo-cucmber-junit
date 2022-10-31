Feature: Examples of Cucumber data table implementations

  Scenario: Lists of fruits i like
    Then user should see fruits i like
      | kiwi        |
      | banana      |
      | cucumba     |
      | orange      |
      | mango       |
      | grape       |
      | pomegranate |

    #mac: command +option+l


  Scenario: User should be able to see all 12 months in months
  dropdown
    Given User is on the dropdowns page of practice tool
    Then User should see below info in month dropdown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |






