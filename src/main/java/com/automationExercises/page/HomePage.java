package com.automationExercises.page;

import com.automationExercises.component.MenuItemComponent;
import com.automationExercises.component.ProductsComponent;
import com.automationExercises.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(id = "scrollUp")
    private WebElement scrollUpButton;
    @FindBy(xpath = "//button[text()='Continue Shopping']")
    private WebElement successButton;
    private HeaderPage headerPage;
    private ProductsComponent products;
    private By subscriptionText = By.xpath("//h2[text()='Subscription']");
    private By body = By.cssSelector("body");
    private By fullFledgedH2 = By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']");

    public HomePage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
        products = new ProductsComponent(driver);
    }

    public MenuItemComponent getMenuItem(String itemName) {
        return this.headerPage.getMenuItem(itemName);
    }

    public boolean isLoggedInMenuItemVisible() {
        return getMenuItem(Constants.LOGGED_IN_MENU_ITEM_NAME) != null;
    }

    public WebElement getSubscriptionElement() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionText));
        return element;
    }

    public WebElement getFullFledgetTextElement() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(fullFledgedH2));
        return element;
    }

    public void clickOnScrollUpButton() {
        this.click(scrollUpButton);
    }

    public void scrollDown() {
        driver.findElement(body).sendKeys(Keys.CONTROL, Keys.END);
    }

    public void addProduct(int productId) {
        products.getProduct(productId).addToCart();
        this.click(successButton);
    }

    public HeaderPage getHeaderPage() {
        return headerPage;
    }
}
