package com.amber.pages;

import com.amber.factories.BasePage;
import com.amber.pageobjects.GoogleSignInPageObject;
import com.amber.utility.fileoperation.PropertiesFileReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author : Vinaykumar Gupta
 * @Date 25/03/23
 */
public class GoogleSignInPage extends BasePage {
    private GoogleSignInPageObject googleSignPageObject;
    private PropertiesFileReader propertiesFileReader = new PropertiesFileReader();

    private Logger log = Logger.getLogger(String.valueOf(GoogleSignInPage.class));

    public GoogleSignInPage(WebDriver driver) {
        super(driver);
        googleSignPageObject = new GoogleSignInPageObject();
        PageFactory.initElements(driver, googleSignPageObject);
    }

    public GoogleSignInPage enterEmailIdAndClickOnNext() {
        googleSignPageObject.txtEmail.sendKeys(propertiesFileReader.getUserName());
        log.info("Entering email ID as : " + propertiesFileReader.getUserName());
        googleSignPageObject.btnNext.click();
        log.info("Clicked on Next button");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    public LandingPage enterPasswordAndClickOnNext() {
        waitForElementToBeVisible(googleSignPageObject.txtPassword, 30);
        googleSignPageObject.txtPassword.sendKeys(propertiesFileReader.getPassword());
        log.info("Entering Password");
        googleSignPageObject.btnNext.click();
        log.info("Clicked on Next button");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new LandingPage(driver);
    }
}
