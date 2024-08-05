package com.automationExercises.tests;

import com.automationExercises.model.SearchValue;
import com.automationExercises.page.AllProductsPage;
import com.automationExercises.page.HomePage;
import com.automationExercises.util.TestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.automationExercises.util.Constants.*;
import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    @DataProvider(name = "searchValuesDataProvider")
    public Object[][] searchValuesDataProvider() {
        return TestData.getSearchValues();
    }

    @Test(dataProvider = "searchValuesDataProvider", description = "Test Case 9: Search Product")
    public void testSearchProduct(SearchValue searchValue) {
        homePage = new HomePage(driver);
        this.verifyUserIsInExpectedPage(
                homePage,
                "",
                HOME_PAGE_TITLE,
                homePage.getMenuItem(HOME_MENU_ITEM_NAME));

        allProductsPage = homePage.getHeaderPage()
                .clickOnMenuButton(AllProductsPage.class, PRODUCTS_MENU_ITEM_NAME);
        this.verifyUserIsInExpectedPage(
                allProductsPage,
                PRODUCTS_PAGE_URL,
                PRODUCTS_PAGE_TITLE,
                homePage.getMenuItem(PRODUCTS_MENU_ITEM_NAME));

        allProductsPage.search(searchValue.getValue());
        assertTrue(allProductsPage.isSearchedProductsTextVisible(),
                "Search results header is not visible.");
        assertTrue(allProductsPage.checkSearchFunctionality(searchValue.getValue()),
                "Search functionality did not return expected results.");
    }
}
