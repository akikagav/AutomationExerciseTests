package com.automationExercises.page;

import com.automationExercises.model.Gender;
import com.automationExercises.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    private WebElement accountInformationText;

    @FindBy(id = "id_gender1")
    private WebElement titleMrCheckbox;
    @FindBy(id = "id_gender2")
    private WebElement titleMrsCheckbox;
    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daysSelect;

    @FindBy(id = "months")
    private WebElement monthsSelect;

    @FindBy(id = "years")
    private WebElement yearsSelect;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "country")
    private WebElement countrySelect;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountInformationTitleVisible() {
        return this.isDisplayed(accountInformationText);
    }

    public AccountCreatedPage createAccount(User user) {
        if (user.getTitle() != null) {
            this.click(user.getTitle() == Gender.MALE ? titleMrCheckbox : titleMrsCheckbox);
        }
        this.type(passwordInput, user.getPassword());
        this.select(daysSelect, user.getDayId());
        this.select(monthsSelect, user.getMonthId());
        this.select(yearsSelect, user.getYearId());
        if (user.isSignUpForNewsletter()) {
            this.click(newsletterCheckbox);
        }
        if (user.isReceiveForOffers()) {
            this.click(specialOffersCheckbox);
        }
        this.type(firstNameInput, user.getFirstName());
        this.type(lastNameInput, user.getLastName());
        this.type(companyInput, user.getCompany());
        this.type(address1Input, user.getAddress1());
        this.type(address2Input, user.getAddress2());
        this.select(countrySelect, user.getCountryId());
        this.type(stateInput, user.getState());
        this.type(cityInput, user.getCity());
        this.type(zipcodeInput, user.getZipcode());
        this.type(mobileNumberInput, user.getMobileNumber());
        this.click(createAccountButton);
        return new AccountCreatedPage(driver);
    }

}
