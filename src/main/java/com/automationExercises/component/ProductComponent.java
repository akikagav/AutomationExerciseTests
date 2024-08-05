package com.automationExercises.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductComponent extends BaseComponent {

    private By productName = By.cssSelector("div.productinfo p");

    private By addToCartButton = By.cssSelector("div.productinfo a");

    private By productId = By.cssSelector("a[data-product-id]");

    public ProductComponent(WebElement root) {
        super(root);
    }

    public int getProductId() {
        return Integer.parseInt(root.findElement(addToCartButton).getAttribute("data-product-id"));
    }

    public String getProductName() {
        return root.findElement(productName).getText();
    }

    public void addToCart() {
        root.findElement(addToCartButton).click();
    }


}
