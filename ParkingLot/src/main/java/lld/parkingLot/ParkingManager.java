package lld.parkingLot;

import lld.parkingLot.Vehicle.VehicleSize;
import lld.parkingLot.ParkingSpot.ParkingSpot;
import lld.parkingLot.Vehicle.Vehicle;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ParkingManager {
    private final Map<VehicleSize, List<ParkingSpot>> availableSpots;
    private final Map<Vehicle, ParkingSpot> vehicletoSpotMap;

    public ParkingManager(Map<VehicleSize, List<ParkingSpot>> availableSpots) {
        this.availableSpots = availableSpots;
        this.vehicletoSpotMap = new HashMap<>();
    }

    public ParkingSpot findSpotForVehicle(Vehicle vehicle){
        VehicleSize vehicleSize = vehicle.getSize();

        for(VehicleSize size: VehicleSize.values()){
            if(size.ordinal()>= vehicleSize.ordinal()){
                List<ParkingSpot> spots = availableSpots.get(size);
                for(ParkingSpot spot: spots){
                    if(spot.isAvailable()){
                        return spot;
                    }
                }
            }
        }
        return null;
    }
}
