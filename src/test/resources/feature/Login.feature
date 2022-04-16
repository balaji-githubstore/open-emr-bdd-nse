@login
Feature: Login
  In order to maintain the medical records 
  As a user
  I would to like to access the portal

  Background: 
    Given I have browser with open emr page

  @invalid @low
  Scenario: Invalid Credential
    When I enter username as 'john'
    And I enter password as 'john123'
    And I select language as 'English (Indian)'
    And I click on login
    Then I should get error message as 'Invalid username or password123'

  @valid @high
  Scenario Outline: Valid Credential
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I select language as '<language>'
    And I click on login
    Then I should get access to the portal with title as 'OpenEMR'

    Examples: 
      | username  | password  | language         |
      | admin     | pass      | English (Indian) |
      | physician | physician | Dutch            |
