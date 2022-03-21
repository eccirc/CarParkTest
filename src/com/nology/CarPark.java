package com.nology;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarPark {

    private final int nMotorCycleSpots;
    private final int nCarSpots;
    private final int nRegularSpots;
    private int remainingCycleSpaces;
    private int remainingCarSpaces;
    private int remainingRegularSpaces;
    private final List<Vehicle> parkedVehicles = new ArrayList<>();
    public String[] vehicleTypes = {"motorbike", "car", "van"};

    public CarPark(int nMotorCycleSpots, int nCarSpots, int nRegularSpots) {
        this.nMotorCycleSpots = nMotorCycleSpots;
        this.nCarSpots = nCarSpots;
        this.nRegularSpots = nRegularSpots;
        remainingCycleSpaces = nMotorCycleSpots;
        remainingCarSpaces = nCarSpots;
        remainingRegularSpaces = nRegularSpots;
    }

    public int getParkedTypes(){
        int total;
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("Choose vehicles to check - 1: Motorbike, 2: Car, 3: Van");
        choice = input.nextInt();
        total = (int) parkedVehicles.stream().filter(type -> type.getVehicleSize() == choice).count();
        System.out.println("There are " + total + " " + vehicleTypes[choice - 1] + "s in the carpark");
        return total;
    }

    public int totalSpaces(){
        return nMotorCycleSpots + nCarSpots + nRegularSpots;
    }
    public int getAllRemainingSpaces(){
        System.out.println("There are " + remainingCycleSpaces + " motorbike spaces, " + remainingCarSpaces + " car spaces and " + remainingRegularSpaces + " remaining larger spaces");

        return remainingCycleSpaces + remainingCarSpaces + remainingRegularSpaces;
    }
    public boolean parkVehicle(){
        Scanner input = new Scanner(System.in);
        int choice;
        Vehicle vehicle;
        System.out.println("Choose your vehicle - 1: Motorbike, 2: Car, 3: Van");
        choice = input.nextInt();

        //DO - invalid input checking
//        while(input.nextInt() != 1 || input.nextInt() != 2 || input.nextInt() != 3){
//            System.out.println("Invalid number. Please enter 1, 2 or 3");
//        }
            vehicle = new Vehicle(vehicleTypes[choice - 1], choice);
            if(checkSpaces(vehicle)){
                parkedVehicles.add(vehicle);
                System.out.println("You have successfully parked your " + vehicle.getVehicleType());
                return true;
            }
            else System.out.println("Sorry, there is not enough space for your " + vehicle.getVehicleType() + "!");
            return false;



    }

    public int getRemainingCycleSpaces() {
        return remainingCycleSpaces;
    }

    public int getRemainingCarSpaces() {
        return remainingCarSpaces;
    }

    public int getRemainingRegularSpaces() {
        return remainingRegularSpaces;
    }

    private boolean checkSpaces(Vehicle v) {
        if (getRemainingCycleSpaces() == 0 && getRemainingCarSpaces() == 0 && getRemainingRegularSpaces() == 0) {
            return false;
        }
        else {
            if (v.getVehicleSize() == 3) {
                System.out.println("Trying to park: " + v.getVehicleType());
                if (getRemainingRegularSpaces() >= 3) {
                    remainingRegularSpaces -= 3;
                    return true;
                } else return false;

            }
            else if (v.getVehicleSize() == 2) {
                System.out.println("Trying to park: " + v.getVehicleType());
                if (getRemainingCarSpaces() >= 1) {
                    remainingCarSpaces -= 1;
                    return true;
                } else if (getRemainingRegularSpaces() >= 1 && getRemainingCarSpaces() == 0) {
                    remainingRegularSpaces -= 1;
                    return true;
                } else return false;

            }
            else if(v.getVehicleSize() == 1) {
                System.out.println("Trying to park: " + v.getVehicleType());
                if (getRemainingCycleSpaces() == 0 && getRemainingCarSpaces() == 0 && getRemainingRegularSpaces() >= 1) {
                    remainingRegularSpaces -= 1;
                    return true;
                } else if (getRemainingCycleSpaces() == 0 && getRemainingCarSpaces() >= 1) {
                    remainingCarSpaces -= 1;
                    return true;
                } else if (getRemainingCycleSpaces() >= 1) {
                    remainingCycleSpaces -= 1;
                    return true;
                } else return false;
            }
            else return false;
        }
    }


}
