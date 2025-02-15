package parkinglot;

import parkinglot.strategy.FirstComeFirstServeParkingStrategy;
import parkinglot.strategy.ParkingSpotStrategy;
import parkinglot.vehicle.Car;
import parkinglot.vehicle.Vehicle;

public class ParkingSystemDemo {
    public static void main(String[] args) {
        ParkingSystem parkingSystem = ParkingSystem.INSTANCE;
        ParkingFloor parkingFloor = new ParkingFloor(0, 10);
        ParkingSpotStrategy parkingSpotStrategy = new FirstComeFirstServeParkingStrategy();
        Vehicle vehicle = new Car("2025-01-15");

        parkingFloor.setParkingSpotStrategy(parkingSpotStrategy);
        parkingSystem.addFloor(parkingFloor);

        System.out.println("Parked Vehicle :: " + parkingSystem.parkVehicle(vehicle));
        parkingSystem.displayAvailability();

        parkingSystem.unparkVehicle(vehicle);
        parkingSystem.displayAvailability();
    }
}
