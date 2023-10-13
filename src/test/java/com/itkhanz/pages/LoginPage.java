package com.itkhanz.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.wundermobility.qatest:id/edtLoginEmail")
    private WebElement emailInput;

    @AndroidFindBy(id = "com.wundermobility.qatest:id/edtLoginPassword")
    private WebElement passwordInput;

    @AndroidFindBy(id = "com.wundermobility.qatest:id/btnLogin")
    private WebElement loginBtn;

    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtLoginError")
    private WebElement loginErr;

    public HomePage performLogin(String email, String password) {
        return this.enterEmail(email).enterPassword(password).pressLoginButton();
    }

    public boolean isLoginErrorDisplayed() {
        logger.info("checking for visibility of login error message");
        return isElementDisplayed(loginErr);
    }

    public LoginPage enterEmail(String email) {
        logger.info("typing {} into email input", email);
        type(emailInput, email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        logger.info("typing {} into password input", password);
        type(passwordInput, password);
        return this;
    }

    public HomePage pressLoginButton() {
        logger.info("clicking on the login button");
        tap(loginBtn);
        return new HomePage(driver);
    }
}
