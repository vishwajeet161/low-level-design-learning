package RideSharingApp.v2;

public class Bike extends Vehicle{

    public Bike(String licensePlate){
        super(licensePlate);
    }

    @Override
    public double getFarePerKm() {
        return 10.0;
    }

}
