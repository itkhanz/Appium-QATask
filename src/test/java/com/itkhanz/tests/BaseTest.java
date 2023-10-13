package com.itkhanz.tests;

import com.itkhanz.config.constants.PlatformOS;
import com.itkhanz.core.DriverManager;
import com.itkhanz.pages.HomePage;
import com.itkhanz.pages.LoginPage;
import com.itkhanz.pages.VehiclesListPage;
import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    AppiumDriver driver;

    LoginPage loginPage;
    HomePage homePage;
    VehiclesListPage vehiclesListPage;

    @BeforeMethod(alwaysRun = true)
    public void setup(Method m) {
        logger.info("****** Started test:" + m.getName() + " ******");
        driver = DriverManager.initializeDriver(PlatformOS.ANDROID);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method m) {
        DriverManager.shutdownDriver();
        logger.info("****** Finished test:" + m.getName() + " ******");
    }
}
