package ZoomRental;

public class Location {
    String address;
    String city;
    String pincode;
    String state;

    public Location(String address, String city, String pincode, String state) {
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
