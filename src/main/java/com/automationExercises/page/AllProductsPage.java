package com.automationExercises.page;

import com.automationExercises.component.ProductsComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProductsPage extends BasePage {

    @FindBy(id = "search_product")
    private WebElement searchInput;
    @FindBy(id = "submit_search")
    private WebElement searchButton;
    @FindBy(xpath = "//h2[text()='Searched Products']")
    private WebElement searchedProductsText;

    private ProductsComponent products;

    public AllProductsPage(WebDriver driver) {
        super(driver);
        products = new ProductsComponent(driver);
    }

    public void search(String searchValue) {
        this.type(searchInput, searchValue);
        this.click(searchButton);
    }

    public boolean isSearchedProductsTextVisible() {
        return this.isDisplayed(this.searchedProductsText);
    }

    public boolean checkSearchFunctionality(String searchValue) {
        return products.getProducts()
                .stream()
                .allMatch(item -> item.getProductName().toLowerCase().contains(searchValue.toLowerCase()));
    }


}
