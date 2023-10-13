package com.itkhanz.tests;

import com.itkhanz.models.User;
import com.itkhanz.models.UserFactory;
import com.itkhanz.pages.cards.VehicleRentCard;
import com.itkhanz.utils.GestureUtils;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VehicleLocateTest extends BaseTest {

    @BeforeMethod
    public void login() {
        User user = UserFactory.createUser("validUser");
        homePage = loginPage.performLogin(user.getUsername(), user.getPassword());
    }

    @Test(description = "when no vehicle is selected on map, locate vehicle button should be disabled")
    public void test_locate_selected_vehicle_button_disabled(){
        homePage.locateVehicle();
        assertThat(homePage.isLocateVehicleButtonEnabled()).isFalse();
    }

    @Test(description = "when vehicle is selected on map, it should display vehicle details")
    public void test_selected_vehicle_details(){
        VehicleRentCard vehicleRentCard = homePage.selectElectricBike();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(vehicleRentCard.getVehicleType()).isEqualTo("Electric Bike");
        softly.assertThat(vehicleRentCard.getVehicleName()).isEqualTo("Electric Bike B4");
        softly.assertThat(vehicleRentCard.getVehicleDescription()).isEqualTo("Go green with this e-bike.");
        softly.assertAll();
    }

    @Test(description = "when vehicle is selected on map, tapping the close icon should close the vehicle details")
    public void test_selected_vehicle_details_closing(){
        VehicleRentCard vehicleRentCard = homePage.selectElectricBike();
        assertThat(vehicleRentCard.isVehicleDetailsCardDisplayed()).isTrue();

        vehicleRentCard.closeVehicleCard();
        assertThat(vehicleRentCard.isVehicleDetailsCardDisplayed()).isFalse();
    }

    @Test(description = "when vehicle is selected on map and you move away, tapping locate vehicle button should navigate you back to selected vehicle")
    public void test_locate_selected_vehicle_button_navigation(){
        VehicleRentCard vehicleRentCard = homePage.selectElectricBike();
        String vehicleSelected = vehicleRentCard.getVehicleName();
        GestureUtils.swipe(driver, "up");
        homePage.locateVehicle();
        vehicleRentCard.closeVehicleCard();
        vehicleRentCard = homePage.selectElectricBike();
        String vehicleSelectedAfterNavigation = vehicleRentCard.getVehicleName();
        assertThat(vehicleSelected).isEqualTo(vehicleSelectedAfterNavigation);
    }
}
