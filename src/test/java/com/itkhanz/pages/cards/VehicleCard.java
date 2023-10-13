package com.itkhanz.pages.cards;

import com.itkhanz.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public abstract class VehicleCard extends BasePage {
    public VehicleCard(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

}
