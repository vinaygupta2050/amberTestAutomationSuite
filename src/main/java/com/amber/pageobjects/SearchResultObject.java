package com.amber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author : Vinaykumar Gupta
 * @Date 23/03/23
 */
public class SearchResultObject {

    @FindBy(xpath = "//*[@id=\"search-top-content-left-container\"]/div[1]/div/div[2]/h1/b")
    public WebElement lblSearchResultTitle;

    @FindBy(xpath="xpath(\"//*[@id=\\\"search-suggestions-container\\\"]\"")
    public WebElement locationSuggesstionList;

    @FindBy(xpath="//span[@class='tag']")
    public WebElement lblTotalResultFound;

}
