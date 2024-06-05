package ZoomRental;

import java.time.LocalDate;

public class Reservation {
    int id;
    LocalDate from_date;
    LocalDate to_date;
    int numberOfHours;
    Vehicle vehicle;
    User user;
    ReservationType reservationType;

    public Reservation(int id, LocalDate from_date, LocalDate to_date, int numberOfHours, Vehicle vehicle, User user) {
        this.id = id;
        this.from_date = from_date;
        this.to_date = to_date;
        this.numberOfHours = numberOfHours;
        this.vehicle = vehicle;
        this.user = user;
        reservationType = ReservationType.IN_PROGRESS;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
