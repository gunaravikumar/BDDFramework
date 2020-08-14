package Steps;

import com.pages.DomainManagementPage;
import com.reusable.BasePage;
import com.reusable.BrowserUtils;
import com.reusable.ConfigureProperties;
import com.reusable.ObjectRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.Properties;

public class LoginPageSteps extends BasePage {

    private WebDriver driver;
    BrowserUtils browserUtils = new BrowserUtils();
    public DomainManagementPage domainManagementPage = new DomainManagementPage();
    Properties configProp;
    {
        try {
            configProp = ConfigureProperties.readPropertiesFile("src/config.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Given("Launch the Browser")
    public void launchTheBrowser() throws InterruptedException {
        driver = browserUtils.invokeBrowser(configProp.getProperty("BrowserName"));
    }

    @When("Enter the ICA URL")
    public void enterTheICAURL() throws InterruptedException {
        driver.get(configProp.getProperty("ICA_URL"));
        Thread.sleep(5000);
    }

    @And("Enter the UserName and Password in Respective TextBox")
    public void enterTheUserNameAndPasswordInRespectiveTextBox() {
        getElement(driver, "cssSelector", ObjectRepository.loginUserName).sendKeys(configProp.getProperty("UserName"));
        System.out.println("UserName is : " + configProp.getProperty("UserName"));
        getElement(driver, "cssSelector", ObjectRepository.loginPassword).sendKeys(configProp.getProperty("Password"));
        System.out.println("Password is : " + configProp.getProperty("Password"));
    }

    @And("Click on Login Button")
    public void clickOnLoginButton() {
        getElement(driver, "cssSelector", ObjectRepository.loginButton).click();
    }

    @Then("Domain Management page should be displayed")
    public void isDisplayedDomainManagementPage() {
        domainManagementPage.isDisplayedDomainManagementPage(driver);
    }

    public WebDriver getDriver()
    {
        return driver;
    }

}
