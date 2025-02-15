package parkinglot.vehicle;

public abstract class Vehicle {
    private final VehicleType vehicleType;
    private final String licenseNumber;

    public Vehicle(VehicleType vehicleType, String licenseNumber) {
        this.vehicleType = vehicleType;
        this.licenseNumber = licenseNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
