Feature: Registration new account at booking.com

  Scenario: My registration scenario
    Given I register new email
    When I register new user on booking
    When I confirm email about registration
    When I login in to booking account
    When I verify booking account
    Then I passed test