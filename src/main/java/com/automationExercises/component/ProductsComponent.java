package com.automationExercises.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsComponent {
    private WebDriver driver;
    @FindBy(css = "div.features_items div.col-sm-4")
    private List<WebElement> products;

    public ProductsComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public List<ProductComponent> getProducts() {
        return products.stream()
                .map(e -> new ProductComponent(e))
                .toList();
    }

    public ProductComponent getProduct(int id) {
        return getProducts()
                .stream()
                .filter(item -> item.getProductId() == id)
                .findFirst()
                .orElseThrow();
    }


}
