package RideSharingApp.v2;

abstract class Vehicle {

    protected String licensePlate;

    public Vehicle(String licensePlate){
        this.licensePlate = licensePlate;
    }
    public abstract double getFarePerKm();
}
