package com.nology;

public class Vehicle {

    private String vehicleType;
    private int vehicleSize;

    public Vehicle(String vehicleType, int vehicleSize) {
        this.vehicleType = vehicleType;
        this.vehicleSize = vehicleSize;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getVehicleSize() {
        return vehicleSize;
    }
}
