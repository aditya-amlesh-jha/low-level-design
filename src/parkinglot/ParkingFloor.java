package parkinglot;

import parkinglot.strategy.ParkingSpotStrategy;
import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private ParkingSpotStrategy parkingSpotStrategy;
    private final List<ParkingSpot> parkingSpotList;
    private final int floor;

    public ParkingFloor(int floor, int noOfSpots){
        this.floor = floor;
        this.parkingSpotList = new ArrayList<>();

        int spotForBike = (int)Math.floor(0.3*noOfSpots);
        int spotForCar = (int)Math.floor(0.5*noOfSpots);
        int spotForTruck = noOfSpots - spotForCar - spotForBike;

        initSpotsForVehicle(parkingSpotList, spotForBike, VehicleType.BIKE);
        initSpotsForVehicle(parkingSpotList, spotForCar, VehicleType.CAR);
        initSpotsForVehicle(parkingSpotList, spotForTruck, VehicleType.TRUCK);
    }

    public void setParkingSpotStrategy(ParkingSpotStrategy parkingSpotStrategy){
        this.parkingSpotStrategy = parkingSpotStrategy;
    }

    private void initSpotsForVehicle(List<ParkingSpot> parkingSpotList, int noOfSpot, VehicleType vehicleType){
        for(int i=0;i<noOfSpot;i++){
            parkingSpotList.add(new ParkingSpot(i, vehicleType));
        }
    }

    public boolean parkVehicle(Vehicle vehicle){
        return parkingSpotStrategy.parkVehicle(parkingSpotList, vehicle);
    }

    public boolean unparkVehicle(Vehicle vehicle){
        for(ParkingSpot parkingSpot: parkingSpotList){
            if(parkingSpot.unparkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        System.out.println("Floor Level :: " + floor);
        for(ParkingSpot parkingSpot: parkingSpotList){
            System.out.println(parkingSpot);
        }
    }
}
