package ZoomRental;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class ZoomRentalController {
    ArrayList<Store> stores;
    ArrayList<Vehicle> vehicles;

    public ZoomRentalController(ArrayList<Vehicle> vehicles, ArrayList<Store> stores) {
        this.vehicles = vehicles;
        this.stores = stores;
    }

    public void addStore(Store store){
        stores.add(store);
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public ArrayList<Store> findStore(String city, String pincode){
        ArrayList<Store> foundStores = new ArrayList<Store>();
        for(Store store: stores){
            if(Objects.equals(store.getLocation().getCity(), city) && Objects.equals(store.getLocation().getPincode(), pincode)){
                foundStores.add(store);
            }
        }

        if(foundStores.isEmpty())
            throw new NullPointerException("No stores found for this pincode");

        return foundStores;
    }

    public Reservation bookVehicle(Store store, User user, Vehicle vehicle, LocalDate fromDate, LocalDate toDate, int numberOfHours) throws Exception{
        if(!vehicle.isAvailable){
            throw new Exception("Selected Vehicle is not available");
        }
        Reservation reservation = store.createReservation(user, vehicle, fromDate, toDate, numberOfHours);
        return reservation;
    }

    public int submitVehicle(Vehicle vehicle, Store store){
        Reservation reservation = store.findReservation(vehicle);
        Bill newBill = new Bill(reservation);
        int cost = newBill.calculateCost();
        return cost;
    }

    public boolean doPayment(int amount, Reservation reservation){
        Random random = new Random();
        Payment payment = new Payment(random.nextInt());
        boolean isSuccess = payment.makePayment(amount);
        if(isSuccess) {
            reservation.setReservationType(ReservationType.COMPLETED);
            reservation.getVehicle().setAvailable(true);
        }
        return isSuccess;
    }

    public ArrayList<Vehicle> getAvailableVehicle(Store store){
        ArrayList<Vehicle> availableVehicles = new ArrayList<>();
        for(Vehicle vehicle: store.getVehicles()){
            if(vehicle.isAvailable()){
                availableVehicles.add(vehicle);
            }
        }

        if(availableVehicles.isEmpty())
            throw new NullPointerException("No available vehicle found in store");

        return availableVehicles;
    }

}
