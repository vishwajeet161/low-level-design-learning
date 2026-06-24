package lld.parkingLot;

import lld.parkingLot.Vehicle.VehicleSize;
import lld.parkingLot.ParkingSpot.ParkingSpot;
import lld.parkingLot.Vehicle.Vehicle;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ParkingManager {
    private final Map<VehicleSize, List<ParkingSpot>> availableSpots;
    private final Map<Vehicle, ParkingSpot> vehicleToSpotMap;

    public ParkingManager(Map<VehicleSize, List<ParkingSpot>> availableSpots) {
        this.availableSpots = availableSpots;
        this.vehicleToSpotMap = new HashMap<>();
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

    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot spot = findSpotForVehicle(vehicle);
        if(spot != null){
            spot.occupy(vehicle);
            vehicleToSpotMap.put(vehicle, spot);
            availableSpots.get(spot.getSize()).remove(spot);
            return spot;
        }
        return null;
    } 
    
    public void unparkVehicle(Vehicle vehicle){
        ParkingSpot spot = vehicleToSpotMap.get(vehicle);
        if(spot != null){
            spot.vacate();
            vehicleToSpotMap.remove(vehicle);
            availableSpots.get(spot.getSize()).add(spot);
        }
    }
}
