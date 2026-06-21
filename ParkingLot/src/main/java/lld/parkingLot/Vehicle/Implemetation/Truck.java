package lld.parkingLot.Vehicle.Implemetation;

import lld.parkingLot.Vehicle.Vehicle;
import lld.parkingLot.Vehicle.VehicleSize;

public class Truck implements Vehicle {
    private final String licensePlate;
    
    public Truck(String licensePlate){
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate() {
        return this.licensePlate;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.LARGE;
    }

}
