import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

// Main service class (Following Single Responsibility Principle)
class EventBookingService implements EventManager, BookingManager {
    private List<Event> events = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private final PaymentProcessor paymentProcessor;
    private static final int MAX_SEATS_PER_BOOKING = 5;

    // Constructor injection (Following Dependency Inversion Principle)
    public EventBookingService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    // Event Management methods
    @Override
    public void addEvent(Event event) {
        events.add(event);
    }

    @Override
    public void removeEvent(int eventId) {
        events.removeIf(event -> event.getId() == eventId);
    }

    @Override
    public void updateEvent(Event updatedEvent) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId() == updatedEvent.getId()) {
                events.set(i, updatedEvent);
                break;
            }
        }
    }

    @Override
    public List<Event> getAllEvents() {
        return new ArrayList<>(events);
    }

    // Booking Management methods
    @Override
    public void createBooking(Booking booking) {
        // Validate booking
        if (booking.getNumberOfSeats() > MAX_SEATS_PER_BOOKING) {
            throw new IllegalArgumentException("Cannot book more than 5 seats");
        }

        Event event = findEvent(booking.getEventId());
        if (event == null || !event.isActive()) {
            throw new IllegalArgumentException("Event not found or not active");
        }

        if (event.getAvailableSeats() < booking.getNumberOfSeats()) {
            throw new IllegalArgumentException("Not enough seats available");
        }

        // Update available seats
        event.setAvailableSeats(event.getAvailableSeats() - booking.getNumberOfSeats());
        bookings.add(booking);

        // Schedule booking timeout
        scheduleBookingTimeout(booking);
    }

    @Override
    public void cancelBooking(int bookingId) {
        Booking booking = findBooking(bookingId);
        if (booking != null) {
            Event event = findEvent(booking.getEventId());
            if (event != null) {
                event.setAvailableSeats(event.getAvailableSeats() + booking.getNumberOfSeats());
            }
            bookings.removeIf(b -> b.getId() == bookingId);
        }
    }

    @Override
    public List<Booking> getCustomerBookings(String customerName) {
        return bookings.stream()
                .filter(b -> b.getCustomerName().equalsIgnoreCase(customerName))
                .collect(Collectors.toList());
    }

    // Helper methods
    private Event findEvent(int eventId) {
        return events.stream()
                .filter(e -> e.getId() == eventId)
                .findFirst()
                .orElse(null);
    }

    private Booking findBooking(int bookingId) {
        return bookings.stream()
                .filter(b -> b.getId() == bookingId)
                .findFirst()
                .orElse(null);
    }

    private void scheduleBookingTimeout(Booking booking) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!booking.isPaid()) {
                    cancelBooking(booking.getId());
                }
            }
        }, 10 * 60 * 1000); // 10 minutes
    }
}
