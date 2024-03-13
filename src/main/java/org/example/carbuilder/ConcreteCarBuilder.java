package org.example.carbuilder;

public class ConcreteCarBuilder implements CarBuilder {
    private final Car car;

    public ConcreteCarBuilder() {
        this.car = new Car();
    }

    @Override
    public CarBuilder setOwnerName(String ownerName) {
        this.car.setOwnerName(ownerName);
        return this;
    }

    public ConcreteCarBuilder setModel(String model) {
        this.car.setModel(model);
        return this;
    }

    public ConcreteCarBuilder setColor(String color) {
        this.car.setColor(color);
        return this;
    }

    public ConcreteCarBuilder setEngine(String engine) {
        this.car.setEngine(engine);
        return this;
    }

    public ConcreteCarBuilder setFuelType(String fuelType) {
        this.car.setFuelType(fuelType);
        return this;
    }

    public Car build() {
        return this.car;
    }
}
