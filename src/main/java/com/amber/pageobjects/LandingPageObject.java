package com.amber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author : Vinaykumar Gupta
 * @Date 23/03/23
 */
public class LandingPageObject {

    @FindBy(xpath="//img[@alt=\"Amber\"]")
    public WebElement lblTitle;

    @FindBy(xpath="//input[@id='main-search']")
    public WebElement txtSearch;

    @FindBy(xpath="//button[normalize-space()='Search']")
    public WebElement btnSearch;

    @FindBy(xpath="//a[@class='nav-item login-item']")
    public WebElement btnLogin;

    @FindBy(xpath="//*[@id=\"header-container\"]/div[2]/a[5]")
    public WebElement btnLogout;




}
