import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Booking {
    private String userId;
    private Event event;
    private Map<String, Seat> bookedSeats;
    private PaymentMethod paymentMethod;
    private LocalDateTime bookingTime;
    private boolean isPaid;

    public Booking(String userId, Event event) {
        this.userId = userId;
        this.event = event;
        this.bookedSeats = new HashMap<>();
        this.bookingTime = LocalDateTime.now();
        this.isPaid = false;
    }

    public boolean addSeat(String seatId) {
        if (bookedSeats.size() >= 5) {
            return false; // Max 5 biljetter per person
        }

        if (event.isSeatAvailable(seatId)) {
            Seat seat = event.getSeatsMap().get(seatId);
            seat.book(userId);
            bookedSeats.put(seatId, seat);
            return true;
        }
        return false;
    }

    public void setPaymentMethod(PaymentMethod method) {
        this.paymentMethod = method;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(bookingTime.plusMinutes(10));
    }

    public void completePayment() {
        this.isPaid = true;
    }

    public void cancelBooking() {
        bookedSeats.values().forEach(Seat::clearBooking);
        bookedSeats.clear();
    }
}
