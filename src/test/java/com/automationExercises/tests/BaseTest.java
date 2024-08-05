package com.automationExercises.tests;

import com.automationExercises.component.MenuItemComponent;
import com.automationExercises.page.*;
import com.automationExercises.model.BrowserType;
import com.automationExercises.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BaseTest {
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected static final String BROWSER_NAME = PropertiesLoader.loadProperty("browser.name");
    protected static final String APP_URL = PropertiesLoader.loadProperty("app.url");
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;
    protected AccountCreatedPage accountCreatedPage;
    protected AccountDeletedPage accountDeletedPage;
    protected AllProductsPage allProductsPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected PaymentPage paymentPage;
    protected PaymentDonePage paymentDonePage;
    protected WebDriver driver;


    @BeforeMethod
    public void startFromHomePage() {
        driver.get(APP_URL);
        logger.info("BeforeMethod: Navigate to Home Page");
    }

    @BeforeClass
    public void setUp() {
        Optional<String> browserNameOpt = Optional.ofNullable(BROWSER_NAME);
        Optional<String> appUrlOpt = Optional.ofNullable(APP_URL);

        BrowserType browserType = browserNameOpt
                .filter(browserName -> !browserName.isEmpty())
                .map(String::toUpperCase)
                .map(BrowserType::valueOf)
                .orElseThrow(() -> new IllegalArgumentException("Browser name property is missing, empty, or invalid"));

        String appUrl = appUrlOpt
                .filter(url -> !url.isEmpty())
                .orElseThrow(() -> new IllegalArgumentException("App URL property is missing or empty"));

        driver = WebDriverFactory.createWebDriver(browserType);
        driver.get(appUrl);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1));
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        logger.info("AfterClass: Tear Down");
    }

    public void verifyUserIsInExpectedPage(BasePage page, String url, String title, MenuItemComponent menuItem) {
        assertEquals(driver.getCurrentUrl(),
                APP_URL + url,
                "The current URL does not match the expected URL.");
        assertEquals(page.getTitle(),
                title,
                "The page title does not match the expected title.");
        assertTrue(menuItem.isItemSelected(),
                "The menu item is not in the active state as expected.");
    }

}
