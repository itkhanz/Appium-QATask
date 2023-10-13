package com.itkhanz.pages;

import com.itkhanz.models.Vehicle;
import com.itkhanz.pages.cards.VehicleDetailsCard;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.plaf.PanelUI;

public class VehiclesListPage extends BasePage {
    public VehiclesListPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup[2]")
    private WebElement itemCard;

    private WebElement itemType = itemCard.findElement(By.xpath("//android.widget.TextView[@resource-id='com.wundermobility.qatest:id/txtNearbyVehicleListItemType']"));
    private WebElement itemName = itemCard.findElement(By.xpath("//android.widget.TextView[@resource-id='com.wundermobility.qatest:id/txtNearbyVehicleListItemName']"));
    private WebElement itemDescription = itemCard.findElement(By.xpath("//android.widget.TextView[@resource-id='com.wundermobility.qatest:id/txtNearbyVehicleListItemDescription']"));
    private WebElement itemFuelLevel = itemCard.findElement(By.xpath("//android.widget.TextView[@resource-id='com.wundermobility.qatest:id/txtNearbyVehicleListItemFuelLevel']"));
    private WebElement itemPrice = itemCard.findElement(By.xpath("//android.widget.TextView[@resource-id='com.wundermobility.qatest:id/txtNearbyVehicleListItemPrice']"));

    public VehicleDetailsCard openItemCardDetails() {
        tap(itemCard);
        return new VehicleDetailsCard(driver);
    }

    public Vehicle getVehicleItemInList() {
        return Vehicle.builder()
                .type(getText(itemType))
                .name(getText(itemName))
                .details(getText(itemDescription))
                .price(getText(itemPrice))
                .fuelLevel(getText(itemFuelLevel))
                .build();
    }
}
