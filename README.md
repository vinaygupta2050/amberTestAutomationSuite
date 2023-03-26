# Amber WebApp Test Automation Framework

## Getting Started

Below is the project structure
```
|-- README.md
|-- amberTestSuite.xml
|-- logs
|   `-- logfile.log
|-- pom.xml
|-- screenshot
`-- src
    |-- main
    |   |-- java
    |   |   `-- com
    |   |       `-- amber
    |   |           |-- factories
    |   |           |   |-- BasePage.java
    |   |           |   |-- BaseTest.java
    |   |           |   |-- CapabilitiesFactory.java
    |   |           |   `-- DriverFactory.java
    |   |           |-- listeners
    |   |           |   `-- TestListeners.java
    |   |           |-- pageobjects
    |   |           |   |-- GoogleSignInPageObject.java
    |   |           |   |-- LandingPageObject.java
    |   |           |   |-- LoginPageObject.java
    |   |           |   |-- NavigationBarPageObject.java
    |   |           |   |-- PropertyDescriptionPageObject.java
    |   |           |   `-- SearchResultObject.java
    |   |           |-- pages
    |   |           |   |-- GoogleSignInPage.java
    |   |           |   |-- LandingPage.java
    |   |           |   |-- LoginPage.java
    |   |           |   |-- NavigationBar.java
    |   |           |   |-- PropertyDescriptionPage.java
    |   |           |   `-- SearchResultPage.java
    |   |           |-- testData
    |   |           |   `-- SearchFlowTestDataProvider.java
    |   |           `-- utility
    |   |               `-- fileoperation
    |   |                   `-- PropertiesFileReader.java
    |   `-- resources
    `-- test
        |-- java
        |   `-- com
        |       `-- amber
        |           `-- test
        |               `-- SearchFlowTest.java
        `-- resources
            `-- config
                |-- env
                |   `-- QA.properties
                |-- logger
                |   `-- log4j.properties
                `-- testRunner
                    `-- SeleniumGrid.properties

```
Description
-   factories : This directory is the heart of framework and it has some major component which drives the whole framework
-   listeners : This consist of all the test listeners which needs to be executed on certain actions 
-   pageobject: In this package all the web elements of application page are stored.
-   pages : In this package all the application pages and their respective actions are written
-   testData : In this package we will be creating our dataprovider class where we can store/manipulate test data which are required to execute our test with different set of data  
-   utils : In this package contains different utility which we can use while we are writing our automation test like wait function, Different file operation
-   test/resources : This consist of config.properties file where all the application url and test user are present and testng.xml file which we use to run our automation test
-   tests     : This directory where we write our test.
-   screenshot : This directory is responsible for storing failed test case screenshot after run
-   logs : This directory is responsible for storing failed test case screenshot after run
### Prerequisites

Please download below applications and jar before we run our framework

```
-   JDK 1.8 or higher
-   maven
```

## Writing Test

Once you have finished your configuration you can begin writing your test by extending BaseTest to your respective test. Below is the sample code.
```
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

```

## Running the tests

To Run from IDE
-   Simply navigate to "testng.xml".
    Right click on the file and select option Run to the test

To Run from command-line
-   In the project directory use below command to run the test 
```
mvn clean test -Denv="QA" -DrunOn="LOCALHOST" -Dbrowser="CHROME"
```

## After run of test
Below directory are usefull after running the test
- target/surefire-reports/index.html : Under this directory we can find plain testng reports
- screenshot: All the screenshot for failed test can be found here

### Break down into end to end tests

The scenarios which I have tried to cover and present in below files
- verifyExistingUserIsAbleToSearchPropertyBaseOnLocation
- verifyNewUserIsAbleToSearchPropertyBasedOnLocation

```
-   Verify E2E journey of a existing user for search of property/accommodation on the location searched
-   Verify user is able to search property/accommodation on the location searched
```

### And coding style tests

I have used testNG and its annotation to write the automation test

### Execution Logs:

Execution Video:
https://github.com/vinaygupta2050/amberTestAutomationSuite/blob/main/ExecutionVideo/ExecutionVideo.mp4

Logs:
https://github.com/vinaygupta2050/amberTestAutomationSuite/blob/main/ExecutionVideo/logfile.log

## Authors

* **Vinaykumar Gupta**
