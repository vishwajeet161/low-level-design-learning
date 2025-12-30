package RideSharingApp.v2;

import java.util.ArrayList;
import java.util.List;

public class RideMatchingSystem {
    private List<Driver> availableDrivers = new ArrayList<>();
    
    public void registerDriver(Driver driver){
        availableDrivers.add(driver);
    }

    public void requestRide(Passenger passenger, double distance, FareStrategy fareStrategy){
        if(availableDrivers.isEmpty()){
            passenger.notify("No drivers are available right now.");
            return;
        }
        Driver assignedDriver = findNearestDriver(passenger.getLocation());
        if(assignedDriver == null){
            passenger.notify("All drivers are busy right now.");
            return;
        }
        passenger.notify("Ride booked with driver " + assignedDriver.getName());
    }

    private Driver findNearestDriver(Location location){
        double minDistance = Double.MAX_VALUE;
        Driver nearestDriver = null;
        for(Driver driver: availableDrivers){
            double driverDistance = location.calcDistance(driver.getLocation());
            if(driverDistance < minDistance){
                minDistance = driverDistance;
                nearestDriver = driver;
            }
        }
        return nearestDriver;
    }
}
