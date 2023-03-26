package com.amber.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author : Vinaykumar Gupta
 * @Date 23/03/23
 */
public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void waitForElementToBeVisible(WebElement element, long timeOut) {
        new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(timeOut)).until(ExpectedConditions.visibilityOf(element));
    }
}
