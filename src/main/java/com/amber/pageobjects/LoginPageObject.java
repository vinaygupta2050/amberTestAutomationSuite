package com.amber.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author : Vinaykumar Gupta
 * @Date 25/03/23
 */
public class LoginPageObject {

    @FindBy(xpath="//*[@role='dialog']/div[2]/div/div[3]/div[1]")
    public WebElement btnGoogleSignIn;
}
