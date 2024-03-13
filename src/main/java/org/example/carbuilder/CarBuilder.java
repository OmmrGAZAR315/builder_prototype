package org.example.carbuilder;

public interface CarBuilder {
    CarBuilder setOwnerName(String ownerName);
    CarBuilder setModel(String model);
    CarBuilder setColor(String color);
    CarBuilder setEngine(String engine);
    CarBuilder setFuelType(String fuelType);
    Car build();
}
