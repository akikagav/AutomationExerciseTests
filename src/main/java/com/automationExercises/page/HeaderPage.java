package com.automationExercises.page;

import com.automationExercises.component.MenuItemComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderPage extends BasePage {

    @FindBy(css = "div.shop-menu ul li")
    private List<WebElement> menuItems;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public List<MenuItemComponent> getMenuItems() {
        return menuItems.stream()
                .map(e -> new MenuItemComponent(e))
                .toList();
    }

    public MenuItemComponent getMenuItem(String name) {
        return getMenuItems()
                .stream()
                .filter(item -> item.getItemName().contains(name))
                .findFirst()
                .orElseThrow();
    }

    public <T extends BasePage> T clickOnMenuButton(Class<T> t, String itemName) {
        try {
            getMenuItem(itemName).click();
            return t.getConstructor(WebDriver.class).newInstance(driver);
        } catch (NoSuchMethodException e) {
            logger.error("Constructor with WebDriver parameter not found in class: " + t.getName());
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("Error while clicking on menu button and navigating to: " + t.getName());
            e.printStackTrace();
        }
        return null;
    }

}
