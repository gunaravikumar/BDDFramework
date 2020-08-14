package Steps;

import com.reusable.BasePage;
import com.reusable.ObjectRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.pages.DomainManagementPage;


public class DomainManagementSteps extends BasePage {
    private WebDriver driver;
    private LoginPageSteps loginPageSteps;
    public DomainManagementPage domainManagementPage = new DomainManagementPage();

    public DomainManagementSteps(LoginPageSteps loginPageSteps) {
        this.loginPageSteps = loginPageSteps;
        driver =  loginPageSteps.getDriver();
    }

    @Given("Logged in ICA Application")
    public void loggedInICAApplication() {
        System.out.println("Already Logged In");
    }

    @When("Navigate to DomainManagement Page")
    public void navigateToDomainManagementPage() {
        domainManagementPage.navigateToDomainManagementPage(driver);
    }

    @And("Click on New Domain button {string}")
    public void clickOnNewDomainButton(String verifyTitle) throws InterruptedException {
        domainManagementPage.clickOnNewDomainButton(driver, verifyTitle);
    }

    @And("Enter the Values in Domain Information Section {string} {string} {string}")
    public void enterValuesInDomainInformationSection(String setDomainName, String setDomainDescription, String setReceivingInstitution) {
        getElement(driver, "cssSelector", ObjectRepository.domainNameTextBox).sendKeys(setDomainName);
        getElement(driver, "cssSelector", ObjectRepository.domainDescTextBox).sendKeys(setDomainDescription);
        getElement(driver, "cssSelector", ObjectRepository.receivingInstTextBox).sendKeys(setReceivingInstitution);
    }

    @And("Select DataSource from Disconnected ListBox {string}")
    public void selectDataSourceFromDisconnectedListBox(String selectDataSource) {
        Select disConnectedList = new Select(getElement(driver, "cssSelector", ObjectRepository.dataSourceDisConnectedBox));
        disConnectedList.selectByVisibleText(selectDataSource);
    }

    @And("Click on Connect Button")
    public void clickOnConnectButton() {
        getElement(driver, "cssSelector", ObjectRepository.connectButton).click();
    }

    @And("Enter the Values in Admin User Information Section {string} {string} {string} {string}")
    public void enterValuesInAdminUserInformationSection(String setUserID, String setLastName, String setFirstName, String setPassword) {
        getElement(driver, "cssSelector", ObjectRepository.userIDTextBox).sendKeys(setUserID);
        getElement(driver, "cssSelector", ObjectRepository.userLNameTextBox).sendKeys(setLastName);
        getElement(driver, "cssSelector", ObjectRepository.userFNameTextBox).sendKeys(setFirstName);
        getElement(driver, "cssSelector", ObjectRepository.userPasswordTextBox).sendKeys(setPassword);
        getElement(driver, "cssSelector", ObjectRepository.userConfirmPasswordTextBox).sendKeys(setPassword);
    }

    @And("Enter the Values in Admin Role Information Section {string} {string}")
    public void enterValuesInAdminRoleInformationSection(String setRoleName, String setRoleDesc) {
        getElement(driver, "cssSelector", ObjectRepository.roleNameTextBox).sendKeys(setRoleName);
        getElement(driver, "cssSelector", ObjectRepository.roleDescTextBox).sendKeys(setRoleDesc);
    }

    @And("Click on SaveButton in Domain Creation")
    public void clickOnSaveButton() throws InterruptedException {
        getElement(driver, "cssSelector", ObjectRepository.saveButton).click();
        Thread.sleep(5000);
    }


    @And("Ensure that the newly created domain is present in Domain Results table {string}")
    public void verifyCreatedDomainIsExistsInDomainResultsTable(String verifyDomainName) {
        boolean isExists = domainManagementPage.verifyDomainIsExistsInDomainResultsTable(driver, verifyDomainName);
        if (isExists) {
            System.out.println("Ensure that the newly created domain is present in Domain Results table.");
        } else {
            System.out.println("Ensure that the newly created domain is not present in Domain Results table.");
        }
        driver.quit();
    }


    @And("Select the domain created as {string}")
    public void selectTheDomainCreated(String setDomainName) {
        domainManagementPage.selectDomainInDomainResultTable(driver, setDomainName);
    }

    @And("Click on Delete Button")
    public void clickOnDeleteButton() throws InterruptedException {
        getElement(driver, "cssSelector", ObjectRepository.deleteDomainButton).click();
        Thread.sleep(5000);
    }

    @And("Click OK in Confirmation window")
    public void clickOKInConfirmationWindow() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(ObjectRepository.userHomeFrame);
        getElement(driver, "cssSelector", ObjectRepository.confirmDialog).isDisplayed();
        getElement(driver, "cssSelector", ObjectRepository.confirmOkButton).click();
    }

    @And("Ensure that deleted domain is present in Domain Results table {string}")
    public void ensureThatDeletedDomainIsPresentInDomainResultsTable(String verifyDomainName) {
        boolean isExists = domainManagementPage.verifyDomainIsExistsInDomainResultsTable(driver, verifyDomainName);
        if (!isExists) {
            System.out.println("Ensure that deleted domain is not present successfully in Domain Results table.");
        } else {
            System.out.println("Ensure that deleted domain is present in Domain Results table.");
        }
        driver.quit();
    }
}

