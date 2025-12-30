package RideSharingApp.v2;


public class Driver extends User {

    private Vehicle vehicle;

    public Driver(String Name, String Email, Location location, Vehicle vehicle){ 
        super(Name, Email, location);
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }



    


}
