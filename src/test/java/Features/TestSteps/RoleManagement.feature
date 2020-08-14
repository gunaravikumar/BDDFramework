Feature: Function on Role Creation and Deletion

  Background: Launch ICA Application
    Given Launch the Browser
    When Enter the ICA URL
    And Enter the UserName and Password in Respective TextBox
    And Click on Login Button
    Then Domain Management page should be displayed

  Scenario: Role Creation
    Given Logged in ICA Application
    When Navigate to RoleManagement Page
    And Click on NewRole Button
    And Enter the Values in Role Information Section:
      | DomainName      | RoleName | RoleDescription |
      | SuperAdminGroup | TestRole | TestRoleDesc    |
    And UnCheck CheckBox as Use Domain Setting in Tool Configuration
    And UserPreference Option Move to Under ThreeD View Option
    And Click on SaveButton in Role Creation
    Then Ensure that the newly created role as "TestRole" is present in Role Result table
