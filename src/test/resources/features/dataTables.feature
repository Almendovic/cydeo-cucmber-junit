Feature: Examples of Cucumber data table implementations
@wip
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