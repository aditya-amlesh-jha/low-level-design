package parkinglot.strategy;

import parkinglot.ParkingSpot;
import parkinglot.vehicle.Vehicle;

import java.util.List;

public interface ParkingSpotStrategy {
    boolean parkVehicle(List<ParkingSpot> parkingSpotList, Vehicle vehicle);
}
