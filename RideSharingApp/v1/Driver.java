package RideSharingApp.v1;

public class Driver {
    private String Name;
    private Location location;
    private Vehicle vehicle;
    private double rating;
    private int NoOfRides;
    private String status;

    public Driver(String Name, Location location, Vehicle vehicle){
        this.Name = Name;
        this.vehicle = vehicle;
        this.location = location;
        this.rating = 0.0;
        this.NoOfRides = 0;
        this.status = "Available";
    }

    public double getRating() {
        return rating;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void addNoOfRides() {
        this.NoOfRides+=1;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setRating(double rating) {
        if(this.NoOfRides==0) {
            this.rating = rating;
            this.addNoOfRides();
        }else{
            this.rating = (rating+(this.rating*this.NoOfRides))/(this.NoOfRides+1);
            this.addNoOfRides();
        }
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getName() {
        return this.Name;
    }
}
