package com.automationExercises.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage {

    @FindBy(xpath = "//b[text()='Account Created!']")
    private WebElement accountCreatedText;
    @FindBy(css = "[data-qa='continue-button']")
    private WebElement continueButton;

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountCreatedTextVisible() {
        return this.isDisplayed(accountCreatedText);
    }

    public HomePage clickContinueButton() {
        this.click(continueButton);
        return new HomePage(driver);
    }
}
