package com.amber.pages;

import com.amber.factories.BasePage;
import com.amber.pageobjects.LandingPageObject;
import com.amber.pageobjects.SearchResultObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author : Vinaykumar Gupta
 * @Date 23/03/23
 */
public class SearchResultPage extends BasePage {

    private SearchResultObject searchResultObject;
    private Logger log = Logger.getLogger(String.valueOf(SearchResultPage.class));
    private String selectedResultHeaderName;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        this.searchResultObject = new SearchResultObject();
        PageFactory.initElements(driver, searchResultObject);
    }

    public SearchResultPage verifySearchResult(String expectedLocation, String expectedTotalResultCount) {
        waitForElementToBeVisible(searchResultObject.lblSearchResultTitle, 30);
        log.info("Search Result Displayed");
        log.info("Actual Location : " + searchResultObject.lblSearchResultTitle.getText().trim());
        log.info("Actual Total Results Count : " + searchResultObject.lblTotalResultFound.getText().trim());
        log.info("Expected Location : " + expectedLocation);
        log.info("Expected Total Results Count : " + expectedTotalResultCount);
        Assert.assertEquals(searchResultObject.lblSearchResultTitle.getText().trim(), expectedLocation);
        Assert.assertEquals(searchResultObject.lblTotalResultFound.getText().trim(), expectedTotalResultCount);
        return this;
    }

    public SearchResultPage applyFilterSharing(String sharingChoice) {
        log.info("Applying Sharing Filter as :" + sharingChoice);
        WebElement roomTypeFilterName = driver.findElement(By.xpath("//aside[@id='search-sidebar-component-container']//div[5]/div/label[text()='" + sharingChoice + "']"));
        roomTypeFilterName.click();
        return this;
    }

    public PropertyDescriptionPage selectResultBasedOnSequenceNumber(int navigateToResultNumber) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//*[@id=\"search-top-content-left-container\"]/div[2]/div[2]/div[2]/div[1]/div"));
        selectedResultHeaderName = searchResults.get(navigateToResultNumber - 1).findElement(By.xpath("div/div/div[3]/h3/a")).getText().trim().toString();
        searchResults.get(navigateToResultNumber - 1).click();
        log.info("Selecting Search Result Number :" + navigateToResultNumber);
        String parent = driver.getWindowHandle();
        Set<String> childWindow = driver.getWindowHandles();
        for (String window : childWindow) {
            driver.switchTo().window(window);
        }
        return new PropertyDescriptionPage(driver);
    }

    /**
     * This method can be used if we want to select the search result based on the result header
     * @param propertyName
     * @return
     */
    public SearchResultPage selectResultBasedOnPropertyName(String propertyName) {
        WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"search-top-content-left-container\"]/div[2]/div[2]/div[2]/div[1]/div/div/div/div[3]/h3/a[text()='" + propertyName + "']"));
        selectedResultHeaderName = searchResult.getText().trim().toString();
        searchResult.click();
        String parent = driver.getWindowHandle();
        Set<String> childWindow = driver.getWindowHandles();
        for (String window : childWindow) {
            driver.switchTo().window(window);
        }
        return this;
    }

    public SearchResultPage applyFilterRoomType(String roomTypeFilter) {
        log.info("Applying Room Type Filter as :" + roomTypeFilter);
        WebElement roomTypeFilterName = driver.findElement(By.xpath("//aside[@id='search-sidebar-component-container']//div[4]//div[1]//label[text()='" + roomTypeFilter + "']"));
        roomTypeFilterName.click();
        return this;
    }

    public SearchResultPage EntirePlace() {
        return this;
    }


}
