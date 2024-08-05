package com.automationExercises.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentDonePage extends BasePage{
    @FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
    private WebElement successMessage;
    public PaymentDonePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSuccessMessageVisible(){
        return this.successMessage.isDisplayed();
    }
}
