package RideSharingApp.v1;

import java.util.ArrayList;
import java.util.List;

public class RideSharingAppService {
    private List<Driver> drivers;
    private List<Passenger> passengers;

    public RideSharingAppService(){
        this.drivers = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void addDriver(Driver driver){
        this.drivers.add(driver);
    }

    public void addPassenger(Passenger passenger){
        this.passengers.add(passenger);
    }

    public void bookRide(Passenger passenger, double distance){
        if(drivers.isEmpty()){
            System.out.println("No drivers are available for "+passenger.getName());
        }

        Driver assignedDriver = null;
        double minDistance = Double.MAX_VALUE;

        for(Driver dr: this.drivers){
            if(dr.getStatus().equals("Booked")) continue;
            double currentDriverDistance = calcDistance(passenger.getLocation(), dr.getLocation());
            if(minDistance>currentDriverDistance){
                minDistance = currentDriverDistance;
                assignedDriver = dr;
                assignedDriver.setStatus("Booked");
            }
        }

        if(assignedDriver==null){
            System.out.println("All the drivers are busy right now");
            return;
        }
        double expectedFare = calcFare(assignedDriver.getVehicle(), distance);

        System.out.println("Ride booked for "+passenger.getName()+" with driver "+assignedDriver.getName()+" for a fare of "+expectedFare);
    }

    private double calcDistance(Location l1, Location l2){
        //Haversine formula can also be used, ass it is good for sphere, but for now we will use Euclidean forumula
        double dx = l1.getLatitude()-l2.getLatitude();
        double dy = l1.getLongitude()-l2.getLongitude();
        return Math.sqrt(dx*dx+dy*dy);
    }
    private double calcFare(Vehicle vehicle, double distance){
        if(vehicle.getType().equals("car")){
            return distance*20;
        }else if(vehicle.getType().equals(("bike"))){
            return distance*10;
        }else{
            return distance*8;
        }
    }
}
