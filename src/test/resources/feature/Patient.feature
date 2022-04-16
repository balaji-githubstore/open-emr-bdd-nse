@patient
Feature: Patient
  In order to add,delete,modify patient records
  As a admin
  I would like access to the portal and modfiy records

  @addpatient
  Scenario Outline: Add Patient
    Given I have browser with open emr page
    When I enter username as 'admin'
    And I enter password as 'pass'
    And I select language as 'English (Indian)'
    And I click on login
    And I click on patient
    And I click on new-search
    And I fill the form
      | firstname   | lastname   | gender   | dob   |
      | <firstname> | <lastname> | <gender> | <dob> |
    And I click on create new patient
    And I click on confirm create new patient
    And I handle the alertbox
    And I click on close happy birthday popup if shown
    Then I should see the alert text contains '<expectedalertext>'
    And I should see the added patient details as '<expectedpatientname>'

    Examples: 
      | firstname | lastname | dob        | gender | expectedalertext | expectedpatientname                   |
      | John      | Wick     | 2022-04-15 | Male   | Tobacco          | Medical Record Dashboard - John Wick  |
      | Peter     | Paul     | 2022-04-12 | Male   | Tobacco          | Medical Record Dashboard - Peter Paul |
