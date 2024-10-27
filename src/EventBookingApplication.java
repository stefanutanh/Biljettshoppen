public class EventBookingApplication {
    public static void main(String[] args) {
        // Initialize the service with direct payment as default
        EventBookingService bookingService = new EventBookingService(new DirectPayment());

        // Create admin with password "admin123"
        Admin admin = new Admin("admin123");

        // Create and start the UI
        BookingSystemUI ui = new BookingSystemUI(bookingService, admin);
        ui.start();
    }
}