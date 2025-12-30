package RideSharingApp.v2;

public class Passenger extends User {

    public Passenger(String Name, String Email, Location location){
        super(Name, Email, location);
    }

    @Override
    public void notify(String message) {
        System.out.println("Notification to Passenger " + this.Name + ": " + message);
    }

}
