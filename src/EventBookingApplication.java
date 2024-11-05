public class EventBookingApplication {
    public static void main(String[] args) {
        // Initiera tjänsten med direktbetalning som standard
        EventBookingService bookingService = new EventBookingService(new DirectPayment());

        
        Event konsert = new Event(1, "Rock Konsert", "WOOD", 500, 24.99);

        Event forelasning = new Event(2, "RIP Föreläsning", "BRICK", 50, 29.99);

        bookingService.addEvent(konsert);
        bookingService.addEvent(forelasning);

        // Skapa administratör med lösenord "admin123"
        Admin admin = new Admin("admin123");

        // Skapa och starta UI:t
        BookingSystemUI ui = new BookingSystemUI(bookingService, admin);
        ui.start();
    }
}
