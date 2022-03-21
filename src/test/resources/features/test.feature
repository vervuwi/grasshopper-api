Feature: Pet store demo

  @PetStoreDemo
  Scenario: pet store demo - test
    Given I find pet by status available
    Then I check the response

  @PetStoreDemo
  Scenario: pet store demo - test
    Given I find pet by id - failure
    Then I check response for failure