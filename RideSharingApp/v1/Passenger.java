package RideSharingApp.v1;

public class Passenger {
    private String Name;
    private Location location;

    public Passenger(String Name, Location location){
        this.Name = Name;
        this.location = location;
    }

    public String getName() {
        return Name;
    }

    public Location getLocation() {
        return location;
    }
}
