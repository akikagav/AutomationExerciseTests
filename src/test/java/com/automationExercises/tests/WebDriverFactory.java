package com.automationExercises.tests;

import com.automationExercises.model.BrowserType;
import com.automationExercises.util.PropertiesLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class WebDriverFactory {

    private static final String AD_EXTENSION_PATH =
            PropertiesLoader.loadProperty("chrome.extension.adblock.path");

    private static final String FIREFOX_AD_EXTENSION_PATH =
            PropertiesLoader.loadProperty("firefox.extension.adblock.path");

    /**
     * Factory method, that creates and configures a WebDriver instance based on the specified browser type
     */
    public static WebDriver createWebDriver(BrowserType browserType) {
        WebDriver driver;
        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addExtensions(new File(AD_EXTENSION_PATH));
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                FirefoxProfile profile = new FirefoxProfile();
                profile.addExtension(new File(FIREFOX_AD_EXTENSION_PATH));
                firefoxOptions.setProfile(profile);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addExtensions(new File(AD_EXTENSION_PATH));
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }
        driver.manage().window().maximize();
        return driver;
    }

}
