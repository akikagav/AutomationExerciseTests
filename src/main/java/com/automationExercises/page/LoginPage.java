package com.automationExercises.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private HeaderPage headerPage;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement newUserSignupText;

    @FindBy(css = "[data-qa='signup-name']")
    private WebElement name;

    @FindBy(css = "[data-qa='signup-email']")
    private WebElement signupEmail;

    @FindBy(css = "[data-qa='login-email']")
    private WebElement loginEmail;

    @FindBy(css = "[data-qa='login-password']")
    private WebElement loginPassword;

    @FindBy(css = "[data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(css = "[data-qa='login-button']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
    }

    public boolean isNewUserSignupTextVisible() {
        return this.isDisplayed(this.newUserSignupText);
    }

    public HomePage login(String email, String password){
        this.type(loginEmail, email);
        this.type(loginPassword, password);
        this.click(loginButton);
        return new HomePage(driver);
    }

    public void fillNameInput(String nameValue) {
        this.type(this.name, nameValue);
    }

    public void fillEmailInput(String emailValue) {
        this.type(this.signupEmail, emailValue);
    }

    public RegistrationPage signup() {
        this.click(signupButton);
        return new RegistrationPage(driver);
    }

    public HeaderPage getHeaderPage() {
        return headerPage;
    }
}
