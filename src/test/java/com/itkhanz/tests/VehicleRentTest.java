package com.itkhanz.tests;

import com.itkhanz.models.User;
import com.itkhanz.models.UserFactory;
import com.itkhanz.pages.cards.VehicleRentCard;
import com.itkhanz.utils.GestureUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VehicleRentTest extends BaseTest {
    @BeforeMethod
    public void login() {
        User user = UserFactory.createUser("validUser");
        homePage = loginPage.performLogin(user.getUsername(), user.getPassword());
    }

    @Test(description = "Renting the vehicle should increment the Rides count by one in vehicle details card")
    public void test_vehicle_rent_ride_count() {
        VehicleRentCard vehicleRentCard = homePage.selectElectricBike();
        vehicleRentCard.startRentVehicle();
        vehicleRentCard.endRentVehicle();
        assertThat(vehicleRentCard.getVehicleRides()).isOne();
    }

    @Test(description = "Reopening the vehicle details card should display the total number of rides taken before")
    public void test_vehicle_rent_ride_count_multiple_rides() {
        VehicleRentCard vehicleRentCard = homePage.selectElectricBike();
        int maxRideCount = 3;
        for(int rideCount = 0; rideCount < maxRideCount; rideCount++) {
            vehicleRentCard.takeVehicleRide();
        }
        vehicleRentCard.closeVehicleCard();
        vehicleRentCard = homePage.selectElectricBike();
        assertThat(vehicleRentCard.getVehicleRides()).isEqualTo(maxRideCount);
    }

}
