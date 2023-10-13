package com.itkhanz.tests;

import com.itkhanz.models.User;
import com.itkhanz.models.UserFactory;
import com.itkhanz.models.Vehicle;
import com.itkhanz.pages.cards.VehicleDetailsCard;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VehicleListTest extends BaseTest {
    @BeforeMethod
    public void login() {
        User user = UserFactory.createUser("validUser");
        homePage = loginPage.performLogin(user.getUsername(), user.getPassword());
        vehiclesListPage = homePage.openNearbyVehicleList();
    }

    @Test(description = "When an item in Nearby Vehicles List is tapped, a dialog with the same details for the vehicle should then be shown.")
    public void test_vehicle_details_in_list() {
        Vehicle vehicleItemInList = vehiclesListPage.getVehicleItemInList();
        VehicleDetailsCard vehicleDetailsCard = vehiclesListPage.openItemCardDetails();
        Vehicle vehicleItemInCard = Vehicle.builder()
                .type(vehicleDetailsCard.getVehicleType())
                .name(vehicleDetailsCard.getVehicleName())
                .details(vehicleDetailsCard.getVehicleDescription())
                .price(vehicleDetailsCard.getVehiclePrice())
                .fuelLevel(vehicleDetailsCard.getVehicleFuelLevel())
                .build();
        assertThat(vehicleItemInCard).isEqualTo(vehicleItemInList);

    }
}
