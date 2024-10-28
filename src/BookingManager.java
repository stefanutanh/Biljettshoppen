import java.util.List;

interface BookingManager {
    void createBooking(Booking booking);
    void cancelBooking(int bookingId);
    List<Booking> getCustomerBookings(String customerName);
}