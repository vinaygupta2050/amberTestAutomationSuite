package com.amber.pages;

import com.amber.factories.BasePage;
import com.amber.pageobjects.LandingPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * @author : Vinaykumar Gupta
 * @Date 23/03/23
 */
public class LandingPage extends BasePage {

    private LandingPageObject landingPageObject;
    private Logger log = Logger.getLogger(String.valueOf(LandingPage.class));

    public LandingPage(WebDriver driver) {
        super(driver);
        this.landingPageObject = new LandingPageObject();
        PageFactory.initElements(driver, landingPageObject);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public LandingPage verifyTitle() {
        waitForElementToBeVisible(landingPageObject.lblTitle, 30);
        log.info("Verifying screen title");
        Assert.assertTrue(landingPageObject.lblTitle.isDisplayed());
        log.info("Verification Successfull!!!");
        return this;
    }

    public LandingPage navigateToLandingPage() {
        driver.switchTo().window(LoginPage.getCurrentWindowId);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Navigate to Landing Page");
        Assert.assertTrue(landingPageObject.btnLogout.isDisplayed());
        log.info("Login Successfull!!!");
        return this;
    }

    public SearchResultPage selectLocation(String locationName) {
        waitForElementToBeVisible(landingPageObject.txtSearch, 30);
        landingPageObject.txtSearch.sendKeys(locationName);
        Actions actions = new Actions(driver);
        WebElement location = driver.findElement(By.xpath("//*[@id='search-suggestions-container']/li/div/div/div[2]/span[text()='" + locationName + "']"));
        actions.moveToElement(location).click().build().perform();
        log.info("Select Location as : " + locationName);
        log.info("Initiating Search...");
        return new SearchResultPage(driver);
    }

    public SearchResultPage clickOnSearch() {
        landingPageObject.btnSearch.click();
        log.info("Clicked on Search Button");
        return new SearchResultPage(driver);
    }

    public LoginPage clickOnLoginButton() {
        landingPageObject.btnLogin.click();
        log.info("Clicked on Login Button");
        return new LoginPage(driver);
    }



}
