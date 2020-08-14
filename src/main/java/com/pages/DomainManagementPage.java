package com.pages;

import com.reusable.BasePage;
import com.reusable.ObjectRepository;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DomainManagementPage extends BasePage {

    private final static int LOGGING_TIME_IN_SECS = 200;

    public void navigateToDomainManagementPage(WebDriver driver) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(ObjectRepository.userHomeFrame);
        getElement(driver, "cssSelector", ObjectRepository.titleDomainManagement).click();
        isDisplayedDomainManagementPage(driver);
    }

    public void isDisplayedDomainManagementPage(WebDriver driver) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(ObjectRepository.userHomeFrame);
        getElement(driver, "cssSelector", ObjectRepository.titleDomainManagement).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, LOGGING_TIME_IN_SECS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ObjectRepository.titleDomainManagement)));
    }

    public void clickOnNewDomainButton(WebDriver driver, String verifyTitle) throws InterruptedException {
        driver.switchTo().frame(getElement(driver, "cssSelector", ObjectRepository.tabContentFrame));
        driver.switchTo().frame(getElement(driver, "cssSelector", ObjectRepository.tabContentFrame));
        getElement(driver, "cssSelector", ObjectRepository.newDomainButton).click();
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(ObjectRepository.userHomeFrame);
        String pageTitle = getElement(driver, "cssSelector", ObjectRepository.pageTitleLabel).getText();
        Assert.assertEquals(verifyTitle, pageTitle);
        if (pageTitle.trim().equalsIgnoreCase(verifyTitle)) {
            System.out.println("New Domain Page is Opened Successfully");
        } else {
            System.out.println("New Domain Page is not Opened");
        }
    }

    public boolean verifyDomainIsExistsInDomainResultsTable(WebDriver driver, String verifyDomainName) {
        boolean isExists = false;
        try {
            driver.switchTo().defaultContent();
            driver.switchTo().frame(ObjectRepository.userHomeFrame);
            driver.switchTo().frame(getElement(driver, "cssSelector", ObjectRepository.tabContentFrame));
            driver.switchTo().frame(getElement(driver, "cssSelector", ObjectRepository.tabContentFrame));
            List<WebElement> objTable = driver.findElements(By.xpath(ObjectRepository.domainListTable));
            for (WebElement i : objTable) {
                if (i.getText().trim().equalsIgnoreCase(verifyDomainName)) {
                    System.out.println("Created domain is present in Domain Results table.");
                    isExists = true;
                    break;
                } else {
                    System.out.println("Created domain is not present in Domain Results table.");
                }
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            return isExists;
        }
    }

    public void selectDomainInDomainResultTable(WebDriver driver, String setDomainName) {
        driver.switchTo().frame(getElement(driver, "cssSelector", ObjectRepository.tabContentFrame));
        driver.switchTo().frame(getElement(driver, "cssSelector", ObjectRepository.tabContentFrame));
        List<WebElement> objTable = driver.findElements(By.xpath(ObjectRepository.domainListTable));
        for (WebElement objRow : objTable) {
            if (objRow.getText().trim().equalsIgnoreCase("TestDomain")) {
                objRow.click();
                System.out.println("Created domain is present in Domain Results table.");
                break;
            } else {
                System.out.println("Created domain is not present in Domain Results table.");
            }
        }
    }
}
