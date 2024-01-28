@allure.label.epic:Feature
@allure.label.suite:Suite
@allure.label.subSuite:SubSuite
Feature: An example

  @critical
  @allure.label.jira:AE-2
  Scenario: The example
    Given User opened HOME page
    When User enters 'Gherkin' in to Name input
    And User enters 'Open source' in to Price input
    And User enters 'Cucumber' in to Product category input
    And User clicks by Save button
    Then The Gherkin are listed in the product table

  @critical
  @allure.label.jira:AE-2
  Scenario: The table example
    Given User opened HOME page
    When User deletes 'Cheese' from the product table
    Then The Cheese are not listed in the product table
