package ZoomRental;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Store {
    ArrayList<Vehicle> vehicles;
    ArrayList<Reservation> reservations;
    Location location;
    Semaphore semaphore;
    public Store(ArrayList<Vehicle> vehicles, Location location) {
        this.vehicles = vehicles;
        this.reservations = new ArrayList<>();
        this.location = location;
        semaphore = new Semaphore(1);
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Reservation createReservation(User user, Vehicle vehicle, LocalDate fromDate, LocalDate toDate, int numberOfHours){

        Random random = new Random();
        int id = random.nextInt();
        Reservation reservation = new Reservation(id,fromDate,toDate,numberOfHours,vehicle,user);
        reservations.add(reservation);
        try {
            semaphore.acquire();
            vehicle.setAvailable(false);
        }
        catch (InterruptedException e){
            throw new RuntimeException("Vehicle is already booked, please try another one");
        }
        finally {
            semaphore.release();
        }
        return reservation;
    }

    public Reservation findReservation(Vehicle vehicle){
        Reservation foundReservation= null;
        for(Reservation reservation: reservations){
            if(reservation.vehicle.vid == vehicle.vid)
                foundReservation = reservation;
        }
        if(foundReservation == null)
            throw new NullPointerException("No reservation found for this vehicle in store");

        return foundReservation;
    }
}
