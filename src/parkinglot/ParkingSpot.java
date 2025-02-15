package parkinglot;

import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType spotVehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, VehicleType spotVehicleType) {
        this.spotNumber = spotNumber;
        this.spotVehicleType = spotVehicleType;
    }

    public synchronized boolean isEmpty(){
        return parkedVehicle == null;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle){
        if(isEmpty() && vehicle.getVehicleType() == spotVehicleType){
            parkedVehicle = vehicle;
            return true;
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle){
        if(!isEmpty() && vehicle.equals(parkedVehicle)){
            parkedVehicle = null;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotNumber=" + spotNumber +
                ", spotVehicleType=" + spotVehicleType +
                ", isEmpty=" + isEmpty() +
                '}';
    }
}
