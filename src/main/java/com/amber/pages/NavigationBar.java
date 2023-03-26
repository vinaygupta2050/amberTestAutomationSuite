package com.amber.pages;

import com.amber.factories.BasePage;
import com.amber.pageobjects.NavigationBarPageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author : Vinaykumar Gupta
 * @Date 26/03/23
 */
public class NavigationBar extends BasePage {
    private NavigationBarPageObject navigationBarPageObject;
    private Logger log = Logger.getLogger(String.valueOf(LandingPage.class));

    public NavigationBar(WebDriver driver) {
        super(driver);
        this.navigationBarPageObject = new NavigationBarPageObject();
        PageFactory.initElements(driver, navigationBarPageObject);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void logout() {
        Actions actions = new Actions(driver);
        actions.moveToElement(navigationBarPageObject.profile).click(navigationBarPageObject.optionsLogout).build().perform();
    }
}
