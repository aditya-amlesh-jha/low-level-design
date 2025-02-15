package parkinglot;

import parkinglot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public enum ParkingSystem {
    INSTANCE;

    private final List<ParkingFloor> parkingFloorList;

    private ParkingSystem(){
        parkingFloorList = new ArrayList<>();
    }

    public void addFloor(ParkingFloor parkingFloor){
        parkingFloorList.add(parkingFloor);
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(ParkingFloor parkingFloor: parkingFloorList){
            if(parkingFloor.parkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle){
        for(ParkingFloor parkingFloor: parkingFloorList){
            if(parkingFloor.unparkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        for(ParkingFloor floor: parkingFloorList){
            floor.displayAvailability();
        }
    }
}
