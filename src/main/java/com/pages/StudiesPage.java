package com.pages;

import com.reusable.BasePage;
import com.reusable.ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class StudiesPage extends BasePage {
    private final static int LOGGING_TIME_IN_SECS = 200;

    public void navigateToStudiesPage(WebDriver driver) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(ObjectRepository.userHomeFrame);
        getElement(driver, "cssSelector", ObjectRepository.studiesTab).click();
        getElement(driver, "cssSelector", ObjectRepository.studiesTab).isDisplayed();
    }

    public boolean searchStudyByPatientID(String setPatientID, WebDriver driver) {
        boolean isExists = false;
        try {
            driver.switchTo().defaultContent();
            driver.switchTo().frame(ObjectRepository.userHomeFrame);
            driver.switchTo().frame(getElement(driver, "cssSelector", ObjectRepository.tabContentFrame));
            driver.switchTo().frame(getElement(driver, "cssSelector", ObjectRepository.tabContentFrame));
            getElement(driver, "cssSelector", ObjectRepository.patientIDTextBox).clear();
            getElement(driver, "cssSelector", ObjectRepository.patientIDTextBox).sendKeys(setPatientID);
            getElement(driver, "cssSelector", ObjectRepository.searchButton).click();
            List<WebElement> objHeaderColumns = driver.findElements(By.xpath("//*[@id='gview_gridTableStudyList']//table/thead/tr/th"));
            for (int i = 2; i <= objHeaderColumns.size(); i++) {
                String getHeaderText = driver.findElement(By.xpath("//*[@id='gview_gridTableStudyList']//table/thead/tr/th[" + i + "]")).getText();
                if (getHeaderText.trim().equalsIgnoreCase("Patient ID")) {
                    WebElement objPatientID = driver.findElement(By.xpath("//*[@id='gridTableStudyList']/tbody/tr[2]/td[" + i + "]"));
                    String getPatientID = objPatientID.getText();
                    if (setPatientID.equalsIgnoreCase(getPatientID)) {
                        System.out.println("Study is Exists in StudyList");
                        objPatientID.click();
                        isExists = true;
                        break;
                    }
                }
            }
            if (!isExists) System.out.println("Study is not Exists in StudyList");
        } catch (Exception exp) {
            System.out.println(exp);
        } finally {
            return isExists;
        }
    }

    public void dragAndDropPRThumbnailImage(WebDriver driver, String studyViewer){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(ObjectRepository.userHomeFrame);
        WebElement objPRImage = getElement(driver,"cssSelector", ObjectRepository.thumbnailPRModality);
        List<WebElement> divTag = objPRImage.findElements(By.cssSelector("div.thumbnail.ui-draggable"));
        //List<WebElement> imgTag = driver.findElements(By.cssSelector("img[class$='thumbnailImage']"));
        WebElement objElement2 = null;
        for(WebElement objElement1 : divTag){
            int thumbnailSize = divTag.size();
            objElement1 = objElement1.findElement(By.cssSelector("img.thumbnailImage"));
            if(studyViewer.equalsIgnoreCase("Viewer 1")){
                objElement2 = getElement(driver, "cssSelector", ObjectRepository.seriesViewer1);
            } else if(studyViewer.equalsIgnoreCase("Viewer 2")){
                objElement2 = getElement(driver, "cssSelector", ObjectRepository.seriesViewer2);
            } else if(studyViewer.equalsIgnoreCase("Viewer 3")){
                objElement2 = getElement(driver, "cssSelector", ObjectRepository.seriesViewer3);
            } else if(studyViewer.equalsIgnoreCase("Viewer 4")){
                objElement2 = getElement(driver, "cssSelector", ObjectRepository.seriesViewer4);
            }
            Actions builder = new Actions(driver);
            builder.clickAndHold(objElement1)
                    .clickAndHold(objElement2)
                    .click()
                    .build()
                    .perform();
        }
    }

    public void zoomLevel(String setZoomLevel, WebDriver driver){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(ObjectRepository.userHomeFrame);
    }

}
