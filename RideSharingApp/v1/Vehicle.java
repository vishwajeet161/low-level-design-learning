package RideSharingApp.v1;

public class Vehicle {
    private String Name;
    private String Type;
    private String VehicleNumber;

    public Vehicle(String a, String b){
        this.Name = a;
        this.Type = b;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }
}
