package RideSharingApp.v2;

abstract class User {
    protected String  Name;
    protected String Email;
    protected Location location;

    public User(String Name, String Email, Location location){
        this.Name = Name;
        this.Email = Email;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
    public String getEmail() {
        return Email;
    }
    public String getName() {
        return Name;
    }

    public void setEmail(String email) {
        Email = email;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public void setName(String name) {
        Name = name;
    }

    public abstract void notify(String message);

}
