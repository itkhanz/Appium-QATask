package com.itkhanz.pages.cards;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class VehicleDetailsCard extends VehicleCard {
    public VehicleDetailsCard(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtNearbyVehicleListItemType")
    private WebElement vehicleType;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtNearbyVehicleListItemName")
    private WebElement vehicleName;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtNearbyVehicleListItemDescription")
    private WebElement vehicleDescription;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtNearbyVehicleListItemFuelLevel")
    private WebElement vehicleFuelLevel;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtNearbyVehicleListItemPrice")
    private WebElement vehiclePrice;

    public String getVehicleType() {
        return getText(vehicleType);
    }
    public String getVehicleName() { return getText(vehicleName); }
    public String getVehicleDescription() {
        return getText(vehicleDescription);
    }

    public String getVehicleFuelLevel() {
        return getText(vehicleFuelLevel);
    }

    public String getVehiclePrice() {
        return getText(vehiclePrice);
    }

}
