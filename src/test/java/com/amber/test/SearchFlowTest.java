package com.amber.test;

import com.amber.factories.BaseTest;
import com.amber.pages.LandingPage;
import org.testng.annotations.Test;

/**
 * @author : Vinaykumar Gupta
 * @Date 23/03/23
 */
public class SearchFlowTest extends BaseTest {

    public static final String ROOMTYPE_ENTIRE_PLACE = "Entire Place";
    public static final String ROOMTYPE_PRIVATE_ROOM = "Private Room";
    public static final String ROOMTYPE_SHARED_ROOM = "Shared Room";

    public static final String SHARING_PRIVATE_BATHROOM = "Private Bathroom";
    public static final String SHARING_PRIVATE_KITCHEN = "Private Kitchen";


    @Test(enabled = true, description = "Verify E2E journey of a existing user for search of property/accommodation on the location searched",
            groups = "Task1")
    public void verifyExistingUserIsAbleToSearchPropertyBaseOnLocation() {
        LandingPage landingPage = new LandingPage(driver.get());
        landingPage.verifyTitle()
                .clickOnLoginButton().clickOnGoogleSignIn().enterEmailIdAndClickOnNext().enterPasswordAndClickOnNext()
                .navigateToLandingPage()
                .selectLocation("London")
                .verifySearchResult("London", "127")
                .applyFilterRoomType(ROOMTYPE_ENTIRE_PLACE)
                .applyFilterSharing(SHARING_PRIVATE_BATHROOM)
                .selectResultBasedOnSequenceNumber(2)
                .verifyPropertyTitleAndLocation("Chapter Old Street, London", "Paul St, London, EC2A 4JH, United Kingdom")
                .logout();
    }

    @Test(enabled = true, description = "Verify user is able to search property/accommodation on the location searched",
            groups = "Task")
    public void verifyNewUserIsAbleToSearchPropertyBasedOnLocation() {
        LandingPage landingPage = new LandingPage(driver.get());
        landingPage
                .verifyTitle()
                .selectLocation("London")
                .verifySearchResult("London", "127")
                .applyFilterRoomType(ROOMTYPE_ENTIRE_PLACE)
                .applyFilterSharing(SHARING_PRIVATE_BATHROOM)
                .selectResultBasedOnSequenceNumber(2)
                .verifyPropertyTitleAndLocation("Chapter Old Street, London", "Paul St, London, EC2A 4JH, United Kingdom");
    }
}
