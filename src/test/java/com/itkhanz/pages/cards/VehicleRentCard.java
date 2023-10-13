package com.itkhanz.pages.cards;

import com.itkhanz.pages.BasePage;
import com.itkhanz.pages.HomePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class VehicleRentCard extends VehicleCard {
    public VehicleRentCard(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.wundermobility.qatest:id/layoutCardVehicle")
    private WebElement vehicleDetailsCard;

    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtCardVehicleType")
    private WebElement vehicleType;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtCardVehicleName")
    private WebElement vehicleName;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtCardVehicleDescription")
    private WebElement vehicleDescription;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtNearbyVehicleListItemFuelLevel")
    private WebElement vehicleFuelLevel;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtNearbyVehicleListItemPrice")
    private WebElement vehiclePrice;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtCardVehicleRides")
    private WebElement vehicleRides;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/btnCardVehicleRentVehicle")
    private WebElement vehicleRentStartBtn;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/btnCardVehicleEndRent")
    private WebElement vehicleRentEndBtn;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/btnCardVehicleClose")
    private WebElement vehicleCloseDetails;

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

    public void closeVehicleCard() {
        tap(vehicleCloseDetails);
    }

    public boolean isVehicleDetailsCardDisplayed() {
        return isElementDisplayed(vehicleDetailsCard);
    }

    public void startRentVehicle() {
        tap(vehicleRentStartBtn);
    }
    public void endRentVehicle() {
        tap(vehicleRentEndBtn);
    }
    public void takeVehicleRide() {
        this.startRentVehicle();
        this.endRentVehicle();
    }

    public int getVehicleRides() {
        return Integer.parseInt(getText(vehicleRides).split("Rides: ")[1]);
    }
}
