package com.automationExercises.page;

import com.automationExercises.model.AddressKey;
import com.automationExercises.model.AddressType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//ul[contains(@id, 'address_delivery')]//li")
    private List<WebElement> addressDelivery;
    @FindBy(xpath = "//ul[contains(@id, 'address_invoice')]//li")
    private List<WebElement> addressInvoice;
    @FindBy(className = "check_out")
    private WebElement placeOrderButton;
    @FindBy(name = "message")
    private WebElement description;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage clickOnPlaceOrderButton() {
        this.click(placeOrderButton);
        return new PaymentPage(driver);
    }

    public String getAddressInfo(AddressType type, AddressKey key) {
        List<WebElement> address;
        switch (type) {
            case DELIVERY:
                address = addressDelivery;
                break;
            case INVOICE:
                address = addressInvoice;
                break;
            default:
                throw new IllegalArgumentException("Invalid address type: " + type);
        }

        return address.get(key.getIndex()).getText();
    }

    public void fillDescriptionInput(String message) {
        this.type(this.description, message);
    }
}
