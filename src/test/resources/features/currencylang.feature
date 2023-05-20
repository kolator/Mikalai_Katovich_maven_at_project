Feature: Check currency hover
  Scenario: Hover availability check
    Given I open booking page
    When I close pop-up
    And I find currency icon
    Then I check text in hover