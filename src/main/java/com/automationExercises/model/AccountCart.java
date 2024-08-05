package com.automationExercises.model;

public class AccountCart {
    private String cartName;
    private String cartNumber;
    private String cvc;
    private String expiryMonth;
    private String expiryYear;

    public AccountCart(String cartName, String cartNumber, String cvc, String expiryMonth, String expiryYear) {
        this.cartName = cartName;
        this.cartNumber = cartNumber;
        this.cvc = cvc;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
    }

    public String getCartName() {
        return cartName;
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }
}
