package com.reusable;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    private WebDriver driver;

    public WebDriver invokeBrowser(String browserName) {
        switch (browserName) {
            case "chrome":
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                break;
            default:
                driver = null;
        }
        return driver;
    }

    public WebDriver getDriver()
    {
        return driver;
    }
}
