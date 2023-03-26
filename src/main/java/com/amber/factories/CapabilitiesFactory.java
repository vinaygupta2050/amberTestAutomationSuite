package com.amber.factories;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * @author : Vinaykumar Gupta
 * @Date 23/03/23
 */
public class CapabilitiesFactory {
    public static Capabilities getCapabilities(String browser) {
        switch (browser) {
            case "CHROME":
                return getChromeOptions();
            case "FIREFOX":
                return getFirefoxOptions();
            case "EDGE":
                return getEdgeOptions();
            default:
                throw new IllegalStateException(String.format("%s is not a valid browser choice. Pick your browser from %s." + browser));
        }
    }
    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--headless=chrome");
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.setHeadless(false);
        return firefoxOptions;
    }

    public static EdgeOptions getEdgeOptions() {
        return new EdgeOptions();
    }
}
