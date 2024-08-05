package com.automationExercises.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MenuItemComponent extends BaseComponent {

    private By itemName = By.tagName("a");

    public MenuItemComponent(WebElement root) {
        super(root);
    }

    public String getItemName() {
        return root.findElement(itemName).getText();
    }

    public boolean isItemSelected() {
        return root.findElement(itemName).getAttribute("style").contains("color: orange;");
    }

    public void click() {
        root.findElement(itemName).click();
    }
}
