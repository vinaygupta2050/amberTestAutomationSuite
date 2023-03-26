package com.amber.pages;

import com.amber.factories.BasePage;
import com.amber.pageobjects.PropertyDescriptionPageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Set;

/**
 * @author : Vinaykumar Gupta
 * @Date 25/03/23
 */
public class PropertyDescriptionPage extends BasePage {

    private PropertyDescriptionPageObject propertyDescriptionPageObject;
    private Logger log = Logger.getLogger(String.valueOf(LandingPage.class));

    public PropertyDescriptionPage(WebDriver driver) {
        super(driver);
        this.propertyDescriptionPageObject = new PropertyDescriptionPageObject();
        PageFactory.initElements(driver, propertyDescriptionPageObject);
    }

    public PropertyDescriptionPage verifyPropertyTitleAndLocation(String title, String location) {
        log.info("Verifying Property Title and Location");
        log.info("Expected Title :" + title);
        log.info("Expected Location :" + location);
        log.info("Actual Title :" + propertyDescriptionPageObject.lblPropertyName.getText());
        log.info("Actual Location :" + propertyDescriptionPageObject.lblPropertyLocation.getText());
        Assert.assertEquals(propertyDescriptionPageObject.lblPropertyName.getText(), title);
        Assert.assertEquals(propertyDescriptionPageObject.lblPropertyLocation.getText(), location);
        return this;
    }

    public PropertyDescriptionPage logout() {
        new NavigationBar(driver).logout();
        return this;
    }

}
