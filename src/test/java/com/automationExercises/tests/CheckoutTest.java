package com.automationExercises.tests;

import com.automationExercises.model.AddressKey;
import com.automationExercises.model.AddressType;
import com.automationExercises.model.Gender;
import com.automationExercises.model.User;
import com.automationExercises.page.AccountDeletedPage;
import com.automationExercises.page.CartPage;
import com.automationExercises.page.HomePage;
import com.automationExercises.page.LoginPage;
import com.automationExercises.util.TestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static com.automationExercises.util.Constants.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest {

    @DataProvider(name = "userDataProvider")
    public Object[][] userDataProvider() {
        return TestData.getUserInfo();
    }

    @Test(dataProvider = "userDataProvider",
            description = "Test Case 16: Place Order: Login before Checkout")
    public void testPlaceOrder(User user) {
        registerUser(user);
        homePage = new HomePage(driver);
        this.verifyUserIsInExpectedPage(
                homePage,
                "",
                HOME_PAGE_TITLE,
                homePage.getMenuItem(HOME_MENU_ITEM_NAME));

        loginPage = homePage.getHeaderPage()
                .clickOnMenuButton(LoginPage.class, LOGIN_MENU_ITEM_NAME);
        homePage = loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(homePage.isLoggedInMenuItemVisible(),
                "Login was not successful, Logged In as ... was not visible");

        Arrays.stream(user.getProducts())
                .forEach(productId -> homePage.addProduct(productId));

        cartPage = homePage.getHeaderPage()
                .clickOnMenuButton(CartPage.class, CART_MENU_ITEM_NAME);
        this.verifyUserIsInExpectedPage(
                cartPage,
                CART_PAGE_URL,
                CART_PAGE_TITLE,
                homePage.getMenuItem(CART_MENU_ITEM_NAME));

        checkoutPage = cartPage.clickOnCheckoutButton();
        verifyAddressInformation(user);
        checkoutPage.fillDescriptionInput(user.getCheckoutMessage());
        paymentPage = checkoutPage.clickOnPlaceOrderButton();

        paymentPage.fillCardInformation(user.getCart());

        paymentDonePage = paymentPage.clickOnPayAndConfirmButton();
        assertTrue(paymentDonePage.isSuccessMessageVisible(),
                "'Congratulations! Your order has been confirmed!' is not visible.");

        accountDeletedPage = homePage.getHeaderPage()
                .clickOnMenuButton(AccountDeletedPage.class, DELETE_MENU_ITEM_NAME);
        assertTrue(accountDeletedPage.isAccountDeletedTextVisible(),
                "'ACCOUNT DELETED!' is not visible.");

        accountDeletedPage.clickContinueButton();
    }

    public void registerUser(User user) {
        homePage = new HomePage(driver);
        loginPage = homePage.getHeaderPage().clickOnMenuButton(LoginPage.class, LOGIN_MENU_ITEM_NAME);
        loginPage.fillNameInput(user.getName());
        loginPage.fillEmailInput(user.getEmail());
        registrationPage = loginPage.signup();
        accountCreatedPage = registrationPage.createAccount(user);
        homePage = accountCreatedPage.clickContinueButton();
        loginPage = homePage.getHeaderPage().clickOnMenuButton(LoginPage.class, LOGOUT_MENU_ITEM_NAME);
        loginPage.getHeaderPage().clickOnMenuButton(LoginPage.class, HOME_MENU_ITEM_NAME);
    }

    private void verifyAddressInformation(User user) {
        verifyAddressForType(AddressType.DELIVERY, user);
        verifyAddressForType(AddressType.INVOICE, user);
    }

    private void verifyAddressForType(AddressType type, User user) {
        assertEquals(checkoutPage.getAddressInfo(type, AddressKey.FULL_NAME), getFullName(user),
                "Full Name mismatch for " + type);
        assertEquals(checkoutPage.getAddressInfo(type, AddressKey.COMPANY), user.getCompany(),
                "Company mismatch for " + type);
        assertEquals(checkoutPage.getAddressInfo(type, AddressKey.ADDRESS1), user.getAddress1(),
                "Address1 mismatch for " + type);
        assertEquals(checkoutPage.getAddressInfo(type, AddressKey.ADDRESS2), user.getAddress2(),
                "Address2 mismatch for " + type);
        assertEquals(checkoutPage.getAddressInfo(type, AddressKey.STATE), getCityStateZipcode(user),
                "State mismatch for " + type);
        assertEquals(checkoutPage.getAddressInfo(type, AddressKey.PHONE), user.getMobileNumber(),
                "Phone mismatch for " + type);
    }

    private String getFullName(User user) {
        return Stream.of(
                        user.getTitle() != null ? (user.getTitle().equals(Gender.MALE) ? MALE_TITLE : FEMALE_TITLE) : "",
                        user.getFirstName(),
                        user.getLastName()
                ).filter(part -> part != null && !part.isEmpty())
                .reduce((part1, part2) -> part1 + " " + part2)
                .orElse("");
    }

    private String getCityStateZipcode(User user) {
        return Stream.of(user.getCity(), user.getState(), user.getZipcode())
                .filter(s -> s != null && !s.isEmpty())
                .reduce((a, b) -> a + " " + b)
                .orElse("");
    }


}
