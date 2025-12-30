package RideSharingApp.v2;

public interface FareStrategy {
    double calcFare(Vehicle vehicle, double distanceInKm);
}

class StandardFareStrategy implements FareStrategy {
    @Override
    public double calcFare(Vehicle vehicle, double distanceInKm) {
        return vehicle.getFarePerKm()*distanceInKm;
    }
}

class SharedFareStrategy implements FareStrategy {
    @Override
    public double calcFare(Vehicle vehicle, double distanceInKm) {
        return 0.50 * vehicle.getFarePerKm() * distanceInKm; // 50% discount for shared rides
    }
}

class LuxuryFareStrategy implements FareStrategy {
    @Override
    public double calcFare(Vehicle vehicle, double distanceInKm) {
        return 1.5 * vehicle.getFarePerKm() * distanceInKm; // 50% extra for luxury rides
    }
}
