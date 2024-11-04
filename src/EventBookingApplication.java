public class EventBookingApplication {
    public static void main(String[] args) {
        // Initialize the service with direct payment as default
        EventBookingService bookingService = new EventBookingService(new DirectPayment());

        
        Event konsert = new Event(1, "Rock Konsert", "WOOD", 500, 24.99);

        Event forelasning = new Event(2, "RIP Föreläsning", "BRICK", 50, 29.99);

        bookingService.addEvent(konsert);
        bookingService.addEvent(forelasning);

        // Create admin with password "admin123"
        Admin admin = new Admin("admin123");

        // Create and start the UI
        BookingSystemUI ui = new BookingSystemUI(bookingService, admin);
        ui.start();
    }
}
