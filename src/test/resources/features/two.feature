Feature: My the second feature

  Scenario Outline: My the second scenario
    Given I open site number one
    When I fill "<hello>" in the form
    Then I need to see something
    Examples:
      | hello |
      | hello2 |
      | hello3 |
      | hello4 |
      | hello5 |