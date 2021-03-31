
Feature: DemoQA - Elements page
  Background:
    Given I am on the "Home" page
    And   I click "Elements"
    Then  I am on the "Elements" page


  Scenario: Upload and Download
    When I click "Upload and Download option"
    And  I click "Choose File"
    And  I set "Choose file" to "/files/nani.jpeg"
    Then "Uploaded file path" should contain "C:\fakepath\nani.jpeg"

  @run
  Scenario: Dynamic Properties
    When I click "Dynamic Properties option"
    Then "Text title" should contain "This text has random Id"
    And  I click "Color change button"





