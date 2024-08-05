package com.automationExercises.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(className = "check_out")
    private WebElement checkoutButton;
    @FindBy(css = "[data-qa='continue-button']")
    private WebElement continueButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage clickOnCheckoutButton() {
        this.click(checkoutButton);
        return new CheckoutPage(driver);
    }

}
