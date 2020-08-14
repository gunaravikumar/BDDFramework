Feature: Function on Search and Open Study

  Background: Launch ICA Application
    Given Launch the Browser
    When Enter the ICA URL
    And Enter the UserName and Password in Respective TextBox
    And Click on Login Button
    Then Domain Management page should be displayed

  Scenario: Role Creation
    Given Logged in ICA Application
    When Navigate to Studies Page
    And Search Study by Patient ID as "3090"
    And Open the Study which you search
    Then Verify the Study should be opened