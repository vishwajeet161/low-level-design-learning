package lld.parkingLot.ParkingSpot;

import lld.parkingLot.Vehicle.Vehicle;
import lld.parkingLot.Vehicle.VehicleSize;

public interface ParkingSpot {
    boolean isAvailable();
    void occupy(Vehicle vehicle);
    void vacate();
    int getSpotNumber();
    VehicleSize getSize();
}
