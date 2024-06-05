package ZoomRental;

public class Vehicle {
    int vid;
    String vehicleName;
    int noOfKms;
    int price;
    boolean isAvailable;
    VehicleType vehicleType;

    public Vehicle(int vid, String vehicleName, int noOfKms, int price, boolean isAvailable, VehicleType vehicleType) {
        this.vid = vid;
        this.vehicleName = vehicleName;
        this.noOfKms = noOfKms;
        this.price = price;
        this.isAvailable = isAvailable;
        this.vehicleType = vehicleType;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public int getNoOfKms() {
        return noOfKms;
    }

    public void setNoOfKms(int noOfKms) {
        this.noOfKms = noOfKms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
