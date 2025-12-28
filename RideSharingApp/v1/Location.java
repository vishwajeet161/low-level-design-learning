package RideSharingApp.v1;

public class Location {
    private double longitude;
    private double latitude;

    public Location(double lon, double lat ){
        this.longitude = lon;
        this.latitude = lat;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
