package lld.parkingLot.Vehicle.Implemetation;

import lld.parkingLot.Vehicle.Vehicle;
import lld.parkingLot.Vehicle.VehicleSize;

public class Car implements Vehicle {
    private final String licensePlate;
    
    public Car(String licensePlate){
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate() {
        return this.licensePlate;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.MEDIUM;
    }


}
