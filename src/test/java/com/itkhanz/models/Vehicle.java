package com.itkhanz.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Vehicle {
    private String type;
    private String name;
    private String details;
    private String fuelLevel;
    private String price;
}
