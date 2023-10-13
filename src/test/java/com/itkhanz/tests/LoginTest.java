package com.itkhanz.tests;

import com.itkhanz.models.User;
import com.itkhanz.models.UserFactory;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LoginTest extends BaseTest {

    @Test(description = "when logged in with invalid credentials, error message appears on the screen")
    public void test_login_with_incorrect_credentials() {
        User user = UserFactory.createFakeUser();
        loginPage.performLogin(user.getUsername(), user.getPassword());
        assertThat(loginPage.isLoginErrorDisplayed()).isTrue();
    }

    @Test(description = "when logged in with valid credentials, google map appears on the screen")
    public void test_login_with_correct_credentials() {
        User user = UserFactory.createUser("validUser");
        homePage = loginPage.performLogin(user.getUsername(), user.getPassword());
        assertThat(homePage.isMapDisplayed()).isTrue();
    }

}
