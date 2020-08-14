package com.reusable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    private WebDriver driver;

    public WebElement getElement(WebDriver driver, String locator, String object) {
        WebElement element = null;
        try {
            switch (locator) {
                case "id":
                    element = driver.findElement(By.id(object));
                    break;
                case "name":
                    element = driver.findElement(By.name(object));
                    break;
                case "cssSelector":
                    element = driver.findElement(By.cssSelector(object));
                    break;
                case "xPath":
                    element = driver.findElement(By.xpath(object));
                    break;
                case "className":
                    element = driver.findElement(By.className(object));
                    break;
                case "linkText":
                    element = driver.findElement(By.linkText(object));
                    break;
                case "partialLinkText":
                    element = driver.findElement(By.partialLinkText(object));
                    break;
                case "tagName":
                    element = driver.findElement(By.tagName(object));
                    break;
                default:
                    element = null;
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Exception Occurred while getElement ");
            ex.printStackTrace();
        } finally {
            return element;
        }
    }
}
