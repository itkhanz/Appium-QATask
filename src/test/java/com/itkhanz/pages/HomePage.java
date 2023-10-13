package com.itkhanz.pages;

import com.itkhanz.pages.cards.VehicleRentCard;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Google Map")
    WebElement mapSection;

    @AndroidFindBy(id = "com.wundermobility.qatest:id/btnMapLocateVehicle")
    private WebElement locateVehicleBtn;

    @AndroidFindBy(id = "com.wundermobility.qatest:id/btnMapNearbyVehicles")
    private WebElement nearbyVehiclesBtn;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Google Map\"]/android.view.View[1]")
    private WebElement electricBikeMarker;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Google Map\"]/android.view.View[2]")
    private WebElement kickScooterMarker;

    public boolean isMapDisplayed() {
        logger.info("checking for visibility of maps");
        return isElementDisplayed(mapSection);
    }

    public boolean isLocateVehicleButtonEnabled() {
        logger.info("checking if the locate vehicle button is enabled");
        return isElementEnabled(locateVehicleBtn);
    }

    public VehicleRentCard selectElectricBike() {
        logger.info("tapping on Electric Bike marker to select this vehicle");
        pauseExecution(2500);
        tap(electricBikeMarker);
        pauseExecution(2500);
        return new VehicleRentCard(driver);
    }

    public VehicleRentCard selectKickScooter() {
        logger.info("tapping on Kick Scooter marker to select this vehicle");
        pauseExecution(2500);
        tap(kickScooterMarker);
        pauseExecution(2500);
        return new VehicleRentCard(driver);
    }

    public void locateVehicle() {
        logger.info("Navigating to the selected vehicle");
        tap(locateVehicleBtn);
    }

    public VehiclesListPage openNearbyVehicleList() {
        tap(nearbyVehiclesBtn);
        return new VehiclesListPage(driver);
    }

}
