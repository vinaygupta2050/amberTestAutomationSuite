package com.amber.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author : Vinaykumar Gupta
 * @Date 25/03/23
 */
public class PropertyDescriptionPageObject {
    @FindBy(xpath="//*[@id=\"show-container\"]/div[2]/div[2]/div/div/div[1]/h1")
    public WebElement lblPropertyName;
    @FindBy(xpath="//*[@id=\"show-container\"]/div[2]/div[2]/div/div/div[1]/div[2]/div/span/span[1]")
    public WebElement lblPropertyLocation;
}
