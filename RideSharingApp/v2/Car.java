package RideSharingApp.v2;

public class Car extends Vehicle{

    public Car(String licensePlate){
        super(licensePlate);
    }

    @Override
    public double getFarePerKm() {
        return 20.0;
    }
  
}
