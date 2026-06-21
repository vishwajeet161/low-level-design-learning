package lld.parkingLot.ParkingSpot.Implementation;

import lld.parkingLot.ParkingSpot.ParkingSpot;
import lld.parkingLot.Vehicle.Vehicle;
import lld.parkingLot.Vehicle.VehicleSize;

public class OversizedSpot implements ParkingSpot {
    private final int spotNumber;
    private Vehicle vehicle;

    public OversizedSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.vehicle = null;
    }

    @Override
    public boolean isAvailable() {
        return vehicle == null;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if (isAvailable()) {
            this.vehicle = vehicle;
        } else {
            throw new IllegalStateException("Parking spot is already occupied.");
        }
    }

    @Override
    public void vacate() {
        this.vehicle = null;
    }

    @Override
    public int getSpotNumber() {
        return spotNumber;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.LARGE; // Oversized spots are designed for large vehicles
    }

}
