package com.automationExercises.page;

import com.automationExercises.model.AccountCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage{
    @FindBy(name = "name_on_card")
    private WebElement cardName;
    @FindBy(name = "card_number")
    private WebElement cardNumber;
    @FindBy(name = "cvc")
    private WebElement cvc;
    @FindBy(name = "expiry_month")
    private WebElement expiryMonth;

    @FindBy(name = "expiry_year")
    private WebElement expiryYear;
    @FindBy(id = "submit")
    private WebElement payAndConfirmButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void fillCardInformation(AccountCart cart){
        this.type(cardName, cart.getCartName());
        this.type(cardNumber, cart.getCartNumber());
        this.type(cvc, cart.getCvc());
        this.type(expiryMonth, cart.getExpiryMonth());
        this.type(expiryYear, cart.getExpiryYear());
    }

    public PaymentDonePage clickOnPayAndConfirmButton(){
        this.click(payAndConfirmButton);
        return new PaymentDonePage(driver);
    }

}
