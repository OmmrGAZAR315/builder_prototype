package org.example.carbuilder;

public class CarDirector {
    private final CarBuilder builder;

    public CarDirector(CarBuilder builder) {
        this.builder = builder;
    }

    public Car constructSportCar(String ownerName, String color) {
        if (ownerName.isBlank())
            ownerName = "Unknown";
        if (color.isBlank())
            color = "Red";
        return builder
                .setOwnerName(ownerName)
                .setModel("Sport")
                .setEngine("V8")
                .setColor(color)
                .setFuelType("Petrol")
                .build();
    }

    public Car constructEconomyCar(String ownerName, String color) {
        if (ownerName.isBlank())
            ownerName = "Unknown";
        if (color.isBlank())
            color = "Black";
        return builder
                .setOwnerName(ownerName)
                .setModel("Economy")
                .setEngine("V4")
                .setColor(color)
                .setFuelType("Diesel")
                .build();
    }
}
