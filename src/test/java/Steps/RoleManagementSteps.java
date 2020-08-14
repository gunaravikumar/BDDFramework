package Steps;

import com.pages.RoleManagementPage;
import com.reusable.BasePage;
import com.reusable.ObjectRepository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Map;

public class RoleManagementSteps extends BasePage {

    private WebDriver driver;
    private LoginPageSteps loginPageSteps;
    RoleManagementPage roleManagementPage = new RoleManagementPage();

    public RoleManagementSteps(LoginPageSteps loginPageSteps) {
        this.loginPageSteps = loginPageSteps;
        driver =  loginPageSteps.getDriver();
    }

    @When("Navigate to RoleManagement Page")
    public void navigateToRoleManagementPage() throws InterruptedException {
        roleManagementPage.navigateToRoleManagementPage(driver);
    }

    @And("Click on NewRole Button")
    public void clickOnNewRoleButton() throws InterruptedException {
        roleManagementPage.clickOnNewRoleButton(driver);
    }

    @And("Enter the Values in Role Information Section:")
    public void enterTheValuesInRoleInformationSection(DataTable table) throws Throwable {
        List<Map<String, String>> roleInfoSection = table.asMaps(String.class, String.class);
        String domainName = roleInfoSection.get(0).get("DomainName");
        String roleName = roleInfoSection.get(0).get("RoleName");
        String roleDescription = roleInfoSection.get(0).get("RoleDescription");

        Select domainList = new Select(getElement(driver, "cssSelector", ObjectRepository.domainNameDropDown));
        domainList.selectByVisibleText(domainName);
        getElement(driver, "cssSelector", ObjectRepository.roleNameTextBox).sendKeys(roleName);
        getElement(driver, "cssSelector", ObjectRepository.roleDescTextBox).sendKeys(roleDescription);
    }

    @And("UnCheck CheckBox as Use Domain Setting in Tool Configuration")
    public void uncheckCheckBoxAsUseDomainSettingInToolConfiguration() {
        WebElement domainSetting = getElement(driver, "cssSelector", ObjectRepository.useDomainSettingCheckBox);
        domainSetting.click();
        //Assert.assertFalse("Use Domain Setting CheckBox Should be Uncheck", domainSetting.isEnabled());
        boolean unCheck = domainSetting.isSelected();
        if (!unCheck) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
    }

    @And("UserPreference Option Move to Under ThreeD View Option")
    public void userPreferenceOptionMoveToUnder3DViewOption() {
        WebElement divToolConfiguration = getElement(driver, "cssSelector", ObjectRepository.toolConfiguration);
        WebElement objColumn = divToolConfiguration.findElement(By.cssSelector("div[id='19']"));
        WebElement objGroupItems = objColumn.findElement(By.cssSelector("div[class='groupItems']"));
        WebElement objULTag = objGroupItems.findElement(By.tagName("ul"));
        List<WebElement> objLITag = objULTag.findElements(By.tagName("li"));
        for (WebElement j : objLITag) {
            WebElement objATag = j.findElement(By.tagName("a"));
            WebElement objElement1 = objATag.findElement(By.tagName("img"));
            if (objElement1.getAttribute("title").trim().equalsIgnoreCase("User Preference")) {
                JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
                scrollDown.executeScript("window.scrollBy(0,300)", "");
                WebElement objElement2 = divToolConfiguration.findElement(By.cssSelector("div[id='20']")).findElement(By.cssSelector("div[class='groupItems']")).findElement(By.tagName("ul"));
                Actions builder = new Actions(driver);
                builder.clickAndHold(objElement1)
                        .clickAndHold(objElement2)
                        .click()
                        .build()
                        .perform();
                System.out.println("Success");
                break;
            }
        }
    }

    @And("Click on SaveButton in Role Creation")
    public void clickOnSaveButtonInRoleCreation() throws InterruptedException {
        getElement(driver, "cssSelector", ObjectRepository.saveButton).click();
        Thread.sleep(5000);
    }

    @Then("Ensure that the newly created role as {string} is present in Role Result table")
    public void ensureThatTheNewlyCreatedRoleAsIsPresentInRoleResultTable(String verifyRoleName) {
        boolean isExists = roleManagementPage.verifyRoleIsExistsInRoleResultsTable(driver, verifyRoleName);
        if (isExists) {
            System.out.println("Ensure that the newly created domain is present in Domain Results table.");
        } else {
            System.out.println("Ensure that the newly created domain is not present in Domain Results table.");
        }
    }
}
