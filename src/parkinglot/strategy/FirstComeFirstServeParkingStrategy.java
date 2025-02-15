package parkinglot.strategy;

import parkinglot.ParkingSpot;
import parkinglot.vehicle.Vehicle;

import java.util.List;

public class FirstComeFirstServeParkingStrategy implements ParkingSpotStrategy{
    @Override
    public boolean parkVehicle(List<ParkingSpot> parkingSpotList, Vehicle vehicle){
        for(ParkingSpot parkingSpot: parkingSpotList){
            if(parkingSpot.parkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }
}
