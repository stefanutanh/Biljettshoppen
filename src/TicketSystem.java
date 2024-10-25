import java.util.HashMap;
import java.util.Map;

public class TicketSystem {
    private Map<String, Event> events;
    private Map<String, Booking> activeBookings;

    public TicketSystem() {
        this.events = new HashMap<>();
        this.activeBookings = new HashMap<>();
    }

    public void addEvent(String eventId, Event event) {
        events.put(eventId, event);
    }

    // Lägg till denna metod
    public Event getEvent(String eventId) {
        return events.get(eventId);
    }

    public Booking createBooking(String userId, String eventId) {
        Event event = events.get(eventId);
        if (event != null && event.isTicketReleased()) {
            Booking booking = new Booking(userId, event);
            activeBookings.put(userId, booking);
            return booking;
        }
        return null;
    }

    public boolean addSeatToBooking(String userId, String seatId) {
        Booking booking = activeBookings.get(userId);
        if (booking != null && !booking.isExpired()) {
            return booking.addSeat(seatId);
        }
        return false;
    }

    public void processPayment(String userId, PaymentMethod method) {
        Booking booking = activeBookings.get(userId);
        if (booking != null && !booking.isExpired()) {
            booking.setPaymentMethod(method);
            booking.completePayment();
            System.out.println("Betalning genomförd för användar-ID: " + userId);
        } else {
            System.out.println("Bokning finns inte eller har gått ut!");
        }
    }

    public void cleanupExpiredBookings() {
        activeBookings.entrySet().removeIf(entry -> {
            if (entry.getValue().isExpired()) {
                entry.getValue().cancelBooking();
                System.out.println("Utgången bokning borttagen för användar-ID: " + entry.getKey());
                return true;
            }
            return false;
        });
    }
}