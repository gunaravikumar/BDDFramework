package Steps;

import com.pages.StudiesPage;
import com.reusable.BasePage;
import com.reusable.ObjectRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudiesPageSteps extends BasePage {

    private WebDriver driver;
    private LoginPageSteps loginPageSteps;
    StudiesPage studiesPage = new StudiesPage();
    private final static int LOGGING_TIME_IN_SECS = 200;

    public StudiesPageSteps(LoginPageSteps loginPageSteps) {
        this.loginPageSteps = loginPageSteps;
        driver = loginPageSteps.getDriver();
    }

    @When("Navigate to Studies Page")
    public void navigateToStudiesPage() {
        studiesPage.navigateToStudiesPage(driver);
    }

    @And("Search Study by Patient ID as {string}")
    public void searchStudyByPatientID(String setPatientID) {
        boolean isExists = studiesPage.searchStudyByPatientID(setPatientID, driver);
        if (isExists){
            System.out.println("Study is available in Studies List");
        } else {
            System.out.println("Study is not available in Studies List");
        }
    }

    @And("Open the Study which you search")
    public void openTheStudyWhichYouSearch() throws InterruptedException {
        getElement(driver, "cssSelector", ObjectRepository.enterpriseButton).click();
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, LOGGING_TIME_IN_SECS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ObjectRepository.serverForm)));
        Thread.sleep(2);
    }

    @Then("Verify the Study should be opened")
    public void verifyTheStudyShouldBeOpened() {
        driver.switchTo().frame(ObjectRepository.userHomeFrame);
        WebDriverWait wait = new WebDriverWait(driver, LOGGING_TIME_IN_SECS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ObjectRepository.studyPanel)));
        String getBannerText = getElement(driver, "cssSelector", ObjectRepository.studyBannerText).getText();
        if(getBannerText.trim().contains("3090")){
            System.out.println("Study is opened successfully");
        } else {
            System.out.println("Failed to opened successfully");
        }
        studiesPage.dragAndDropPRThumbnailImage(driver, "Viewer 1");
    }
}
