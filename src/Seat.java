import java.time.LocalDateTime;

public class Seat {
    private String id;
    private SeatType type;
    private boolean isBooked;
    private LocalDateTime bookingTime;
    private String bookedBy;

    public Seat(String id, SeatType type) {
        this.id = id;
        this.type = type;
        this.isBooked = false;
    }

    public boolean isBooked() {
        if (isBooked && bookingTime != null) {
            if (LocalDateTime.now().isAfter(bookingTime.plusMinutes(10))) {
                clearBooking();
                return false;
            }
        }
        return isBooked;
    }

    public void book(String userId) {
        this.isBooked = true;
        this.bookingTime = LocalDateTime.now();
        this.bookedBy = userId;
    }

    public void clearBooking() {
        this.isBooked = false;
        this.bookingTime = null;
        this.bookedBy = null;
    }

    public SeatType getType() {
        return type;
    }
}
