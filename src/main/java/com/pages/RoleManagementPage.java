package com.pages;

import com.reusable.BasePage;
import com.reusable.ObjectRepository;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RoleManagementPage extends BasePage {
    private final static int LOGGING_TIME_IN_SECS = 2000;

    public void navigateToRoleManagementPage(WebDriver driver) throws InterruptedException {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(ObjectRepository.userHomeFrame);
        getElement(driver, "cssSelector", ObjectRepository.roleManagementTab).click();
        getElement(driver, "cssSelector", ObjectRepository.roleManagementTab).isDisplayed();
        Thread.sleep(5000);
        /*WebDriverWait wait = new WebDriverWait(driver, LOGGING_TIME_IN_SECS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ObjectRepository.roleManagementTab)));*/
    }

    public void clickOnNewRoleButton(WebDriver driver) throws InterruptedException {
        driver.switchTo().frame(getElement(driver, "cssSelector", ObjectRepository.tabContentFrame));
        driver.switchTo().frame(getElement(driver, "cssSelector", ObjectRepository.tabContentFrame));
        Thread.sleep(5000);
        //WebDriverWait wait = new WebDriverWait(driver, LOGGING_TIME_IN_SECS);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ObjectRepository.newRoleButton)));
        getElement(driver, "cssSelector", ObjectRepository.newRoleButton).click();
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(ObjectRepository.userHomeFrame);
        String pageTitle = getElement(driver, "cssSelector", ObjectRepository.pageTitleLabel).getText();
        Assert.assertEquals("New Role", pageTitle);
        if (pageTitle.trim().equalsIgnoreCase("New Role")) {
            System.out.println("New Role Page is Opened Successfully");
        } else {
            System.out.println("New Role Page is not Opened");
        }
    }

    public boolean verifyRoleIsExistsInRoleResultsTable(WebDriver driver, String verifyRoleName) {
        boolean isExists = false;
        try {
            driver.switchTo().defaultContent();
            driver.switchTo().frame(ObjectRepository.userHomeFrame);
            driver.switchTo().frame(getElement(driver, "cssSelector", ObjectRepository.tabContentFrame));
            driver.switchTo().frame(getElement(driver, "cssSelector", ObjectRepository.tabContentFrame));
            List<WebElement> objTable = driver.findElements(By.xpath(ObjectRepository.roleListTable));
            for (WebElement i : objTable) {
                if (i.getText().trim().equalsIgnoreCase(verifyRoleName)) {
                    System.out.println("Created Role is present in Role Results table.");
                    isExists = true;
                    break;
                } else {
                    System.out.println("Created Role is not present in Role Results table.");
                }
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            return isExists;
        }
    }
}
