package com.amber.pages;

import com.amber.factories.BasePage;
import com.amber.pageobjects.LandingPageObject;
import com.amber.pageobjects.LoginPageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author : Vinaykumar Gupta
 * @Date 25/03/23
 */
public class LoginPage extends BasePage {
    private LoginPageObject loginPageObject;
    private Logger log = Logger.getLogger(String.valueOf(LoginPage.class));
    public static String getCurrentWindowId = "";

    public LoginPage(WebDriver driver) {
        super(driver);
        this.loginPageObject = new LoginPageObject();
        PageFactory.initElements(driver, loginPageObject);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public GoogleSignInPage clickOnGoogleSignIn() {
        PageFactory.initElements(driver, loginPageObject);
        loginPageObject.btnGoogleSignIn.click();
        log.info("Click on Google Signin");
        getCurrentWindowId = driver.getWindowHandle();
        Set<String> childWindow = driver.getWindowHandles();
        for (String window : childWindow) {
            driver.switchTo().window(window);
        }
        log.info("Navigate to Google Login Screen");
        return new GoogleSignInPage(driver);
    }
}
