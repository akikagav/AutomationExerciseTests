package com.automationExercises.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDeletedPage extends BasePage {

    @FindBy(css = "[data-qa='account-deleted']")
    private WebElement accountDeletedText;
    @FindBy(css = "[data-qa='continue-button']")
    private WebElement continueButton;

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountDeletedTextVisible() {
        return this.isDisplayed(accountDeletedText);
    }

    public HomePage clickContinueButton() {
        this.click(continueButton);
        return new HomePage(driver);
    }
}
