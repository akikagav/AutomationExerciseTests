package com.automationExercises.tests;

import com.automationExercises.model.User;
import com.automationExercises.page.AccountDeletedPage;
import com.automationExercises.page.HomePage;
import com.automationExercises.page.LoginPage;
import com.automationExercises.util.TestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.automationExercises.util.Constants.*;
import static org.testng.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    @DataProvider(name = "userDataProvider")
    public Object[][] userDataProvider() {
        return TestData.getUserInfo();
    }

    @Test(dataProvider = "userDataProvider", description = "Test Case 1: Register User")
    public void testRegistration(User user) {
        homePage = new HomePage(driver);
        this.verifyUserIsInExpectedPage(
                homePage,
                "",
                HOME_PAGE_TITLE,
                homePage.getMenuItem(HOME_MENU_ITEM_NAME));

        loginPage = homePage.getHeaderPage()
                .clickOnMenuButton(LoginPage.class, LOGIN_MENU_ITEM_NAME);
        assertTrue(loginPage.isNewUserSignupTextVisible(),
                "'New User Signup!' is not visible.");

        loginPage.fillNameInput(user.getName());
        loginPage.fillEmailInput(user.getEmail());
        registrationPage = loginPage.signup();
        assertTrue(registrationPage.isAccountInformationTitleVisible(),
                "'ENTER ACCOUNT INFORMATION' is not visible.");

        accountCreatedPage = registrationPage.createAccount(user);
        assertTrue(accountCreatedPage.isAccountCreatedTextVisible(),
                "'ACCOUNT CREATED!' is not visible.");

        homePage = accountCreatedPage.clickContinueButton();
        assertTrue(homePage.isLoggedInMenuItemVisible(),
                "''Logged in as ... ' menu item is not visible.");

        accountDeletedPage = homePage.getHeaderPage().
                clickOnMenuButton(AccountDeletedPage.class, DELETE_MENU_ITEM_NAME);
        assertTrue(accountDeletedPage.isAccountDeletedTextVisible(),
                " 'ACCOUNT DELETED!' is not visible.");

        accountDeletedPage.clickContinueButton();
    }
}
