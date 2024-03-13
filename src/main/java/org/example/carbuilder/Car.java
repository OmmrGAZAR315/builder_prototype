package org.example.carbuilder;

public class Car implements Prototype {
    private String ownerName;
    private String model;
    private String color;
    private String engine;
    private String fuelType;

    @Override
    public Prototype clone() {
        return new Car(this);
    }
    public Car(Car car) {
        this.ownerName = car.ownerName;
        this.model = car.model;
        this.color = car.color;
        this.engine = car.engine;
        this.fuelType = car.fuelType;
    }
    public Car() {
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getModel() {
        return model;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }


}
