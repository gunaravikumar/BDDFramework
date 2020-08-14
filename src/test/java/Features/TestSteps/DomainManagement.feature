Feature: Functionality on Domain Creation and Delete

  Background: Launch ICA Application
    Given Launch the Browser
    When Enter the ICA URL
    And Enter the UserName and Password in Respective TextBox
    And Click on Login Button
    Then Domain Management page should be displayed

  Scenario Outline: Domain Creation
    Given Logged in ICA Application
    When Navigate to DomainManagement Page
    And Click on New Domain button "<Title>"
    And Enter the Values in Domain Information Section "<DomainName>" "<DomainDesc>" "<ReceivingInstitutionName>"
    And Select DataSource from Disconnected ListBox "<DataSource>"
    And Click on Connect Button
    And Enter the Values in Admin User Information Section "<UserID>" "<LastName>" "<FirstName>" "<Password>"
    And Enter the Values in Admin Role Information Section "<RoleName>" "<RoleDescription>"
    And Click on SaveButton in Domain Creation
    Then Domain Management page should be displayed
    And Ensure that the newly created domain is present in Domain Results table "<DomainName>"
    Examples:
      | Title      | DomainName | DomainDesc     | ReceivingInstitutionName | DataSource | UserID | LastName  | FirstName | Password | RoleName       | RoleDescription    |
      | New Domain | TestDomain | TestDomainDesc | Test                     | PA-A6-WS8  | Guna24 | Ravikumar | Guna      | Pa$$word | TestDomainRole | TestDomainRoleDesc |

  Scenario: Domain Deletion
    Given Logged in ICA Application
    When Navigate to DomainManagement Page
    And Select the domain created as "TestDomain"
    And Click on Delete Button
    And Click OK in Confirmation window
    Then Domain Management page should be displayed
    And Ensure that deleted domain is present in Domain Results table "TestDomain"