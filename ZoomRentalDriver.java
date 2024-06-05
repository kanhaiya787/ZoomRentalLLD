import ZoomRental.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class ZoomRentalDriver {
    ZoomRentalController zoomRentalController;
    public ZoomRentalDriver() {
        initialize();
    }

    public void initialize(){
        Vehicle v1 = new Vehicle(1, "Honda Elevate", 8000, 1000, true, VehicleType.FOUR_WHEELER);
        Vehicle v2 = new Vehicle(2, "Hyundai Creta", 5000, 1200, true, VehicleType.FOUR_WHEELER);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(v1);
        vehicles.add(v2);
        //store location
        Location storeLocation = new Location("ECIL Hyd", "Hyderabad", "500040", "Telangana");
        Store store1 = new Store(vehicles, storeLocation);
        ArrayList<Store> stores = new ArrayList<>();
        stores.add(store1);
        zoomRentalController = new ZoomRentalController(vehicles, stores);
    }

    public void performBooking(User user){
        try {
            // Get Stores based on user location
            ArrayList<Store> stores = zoomRentalController.findStore("Hyderabad", "500040");
            //Get available vehicle from that store
            ArrayList<Vehicle> vehicles = zoomRentalController.getAvailableVehicle(stores.get(0));
            LocalDate fromDate = LocalDate.parse("2024-06-01");
            LocalDate toDate = LocalDate.parse("2024-06-03");
            //Create a reservation
            Reservation reservation = zoomRentalController.bookVehicle(stores.get(0), user, vehicles.get(0), fromDate, toDate, 36);
            //Generate rental cost
            int generatedCost = zoomRentalController.submitVehicle(vehicles.get(0), stores.get(0));
            System.out.println("Generated cost of "+generatedCost+" for vehicle: "+reservation.getVehicle().getVehicleName());

            //paybill and set vehicle availability as true
            boolean makePayment = zoomRentalController.doPayment(generatedCost, reservation);
            if(makePayment)
                System.out.println("Payment is successfully done for user "+ reservation.getUser().getUserName()+" and reservation state is changed to "+reservation.getReservationType());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
