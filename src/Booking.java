import java.time.LocalDateTime;

class Booking {
    private int id;
    private int eventId;
    private String customerName;
    private int numberOfSeats;
    private String seatType;  // "BENCH" or "FOLDABLE"
    private boolean isPaid;
    private LocalDateTime bookingTime;

    public Booking(int id, int eventId, String customerName, int numberOfSeats, String seatType) {
        this.id = id;
        this.eventId = eventId;
        this.customerName = customerName;
        this.numberOfSeats = numberOfSeats;
        this.seatType = seatType;
        this.isPaid = false;
        this.bookingTime = LocalDateTime.now();
    }

    // Getters
    public int getId() { return id; }
    public int getEventId() { return eventId; }
    public int getNumberOfSeats() { return numberOfSeats; }
    public boolean isPaid() { return isPaid; }
    public LocalDateTime getBookingTime() { return bookingTime; }

    public void setPaid(boolean paid) {
        this.isPaid = paid;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getSeatType() {
        return seatType;
    }


}
