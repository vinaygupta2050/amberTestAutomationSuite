package com.amber.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author : Vinaykumar Gupta
 * @Date 25/03/23
 */
public class GoogleSignInPageObject{

    @FindBy(xpath = "//input[@type='email']")
    public WebElement txtEmail;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement txtPassword;

    @FindBy(xpath = "//span[text()='Next']")
    public WebElement btnNext;

}