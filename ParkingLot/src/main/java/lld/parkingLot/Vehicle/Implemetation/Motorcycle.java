package lld.parkingLot.Vehicle.Implemetation;

import lld.parkingLot.Vehicle.Vehicle;
import lld.parkingLot.Vehicle.VehicleSize;

public class Motorcycle implements Vehicle {

    private final String licensePlate;

    public Motorcycle(String licensePlate){
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate() {
        return this.licensePlate;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.SMALL;
    }   


}
