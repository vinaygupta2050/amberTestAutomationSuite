package com.amber.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author : Vinaykumar Gupta
 * @Date 26/03/23
 */
public class NavigationBarPageObject {


    @FindBy(xpath="//*[@id=\"header-search-navbar\"]/div[2]/div/div[3]/a/b")
    public WebElement profile;
    @FindBy(xpath="//*[@id=\"header-search-navbar\"]/div[2]/div/div[3]/div/a[5]")
    public WebElement optionsLogout;
}
