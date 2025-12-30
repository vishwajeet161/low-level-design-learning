package RideSharingApp.v2;

enum RideStatus {
    SCHEDULED,
    ONGOING,
    COMPLETED,
    CANCELLED
}

public class Ride {
    private Passenger passenger;
    private Driver driver;
    private double distance;
    private FareStrategy fareStrategy;
    private double fare;
    private RideStatus rideStatus;
    public Ride(Passenger passenger, Driver diriver, double distance, FareStrategy fareStrategy, double fare) {
        this.passenger = passenger;
        this.driver = diriver;
        this.distance = distance;
        this.fareStrategy = fareStrategy;
        this.fare = fare;
        this.rideStatus = RideStatus.SCHEDULED;
    }


    public void calculateFare(){
        this.fare = fareStrategy.calcFare(driver.getVehicle(), distance);
    }

    public void updateRideStatus(RideStatus status){
        this.rideStatus = status;
        notifyUsers();
    }

    private void notifyUsers(){
        passenger.notify("Ride status updated to: " + this.rideStatus);
        driver.notify("Ride status updated to: " + this.rideStatus);
    }

    
    public double getFare() {
        return fare;
    }
   
}
