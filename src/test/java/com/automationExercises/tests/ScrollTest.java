package com.automationExercises.tests;

import com.automationExercises.page.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.automationExercises.util.Constants.HOME_MENU_ITEM_NAME;
import static com.automationExercises.util.Constants.HOME_PAGE_TITLE;
import static org.testng.Assert.assertTrue;

public class ScrollTest extends BaseTest {

    @Test(description = "Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
    public void testScrollUpAndDownFunctionality() throws InterruptedException {
        homePage = new HomePage(driver);
        this.verifyUserIsInExpectedPage(
                homePage,
                "",
                HOME_PAGE_TITLE,
                homePage.getMenuItem(HOME_MENU_ITEM_NAME));

        homePage.scrollDown();
        Thread.sleep(1000);
        assertTrue(isElementInViewport(homePage.getSubscriptionElement()),
                "Subscription is not in the viewport after scrolling down.");

        homePage.clickOnScrollUpButton();
        Thread.sleep(1000);
        assertTrue(isElementInViewport(homePage.getFullFledgetTextElement()),
                "Full-Fledged practice website for Automation Engineers text is not in the viewport after scrolling up.");
    }

    public boolean isElementInViewport(WebElement element) {
        // Ensure that the WebElement is not null
        if (element == null) {
            logger.error("The WebElement cannot be null.");
            throw new IllegalArgumentException("The WebElement cannot be null.");
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript(
                "var elem = arguments[0], " +
                        "  box = elem.getBoundingClientRect(), " +
                        "  cx = box.left + box.width / 2, " +
                        "  cy = box.top + box.height / 2, " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "return e === elem || e.contains(elem);",
                element
        );
    }


}
