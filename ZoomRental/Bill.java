package ZoomRental;

public class Bill {
    Reservation reservation;
    Payment payment;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
    }

    public int calculateCost(){
        //write bill calculation logic
        return 200;
    }
}
