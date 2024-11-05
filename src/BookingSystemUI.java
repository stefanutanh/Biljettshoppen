import java.util.List;
import java.util.Scanner;

class BookingSystemUI {
    private final EventBookingService bookingService;
    private final Admin admin;
    private final Scanner scanner;

    public BookingSystemUI(EventBookingService bookingService, Admin admin) {
        this.bookingService = bookingService;
        this.admin = admin;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Event Booking System ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Rensa buffer

            switch (choice) {
                case 1:
                    handleAdminLogin();
                    break;
                case 2:
                    handleCustomerMenu();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void handleAdminLogin() {
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (admin.verify(password)) {
            showAdminMenu();
        } else {
            System.out.println("Invalid password!");
        }
    }

    private void showAdminMenu() {
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Create Event");
            System.out.println("2. Remove Event");
            System.out.println("3. View All Events");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Rensa buffer

            switch (choice) {
                case 1:
                    createEvent();
                    break;
                case 2:
                    removeEvent();
                    break;
                case 3:
                    viewAllEvents();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void createEvent() {
        System.out.print("Enter event name: ");
        String name = scanner.nextLine();

        System.out.print("Enter building (WOOD/BRICK): ");
        String building = scanner.nextLine().toUpperCase();

        System.out.print("Enter total seats: ");
        int totalSeats = scanner.nextInt();

        System.out.print("Enter ticket price: ");
        double price = scanner.nextDouble();

        Event event = new Event(generateEventId(), name, building, totalSeats, price);
        bookingService.addEvent(event);
        System.out.println("Event created successfully!");
    }

    private void removeEvent() {
        System.out.print("Enter event ID to remove: ");
        int eventId = scanner.nextInt();
        bookingService.removeEvent(eventId);
        System.out.println("Event removed successfully!");
    }

    private void handleCustomerMenu() {
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();

        while (true) {
            System.out.println("\n=== Customer Menu ===");
            System.out.println("1. View Available Events");
            System.out.println("2. Make Booking");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View My Bookings");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Rensa buffer

            switch (choice) {
                case 1:
                    viewAllEvents();
                    break;
                case 2:
                    makeBooking(customerName);
                    break;
                case 3:
                    cancelBooking(customerName);
                    break;
                case 4:
                    viewCustomerBookings(customerName);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void makeBooking(String customerName) {
        viewAllEvents();
        System.out.print("Enter event ID to book: ");
        int eventId = scanner.nextInt();

        System.out.print("Enter number of seats (max 5): ");
        int numberOfSeats = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        System.out.print("Enter seat type (BENCH/FOLDABLE): ");
        String seatType = scanner.nextLine().toUpperCase();

        try {
            Booking booking = new Booking(generateBookingId(), eventId, customerName, numberOfSeats, seatType);
            bookingService.createBooking(booking);

            System.out.println("Booking created! Please select payment method:");
            System.out.println("1. Direct Payment");
            System.out.println("2. Invoice Payment");
            int paymentChoice = scanner.nextInt();

            PaymentProcessor paymentProcessor = paymentChoice == 1 ?
                    new DirectPayment() : new InvoicePayment();

            Event event = bookingService.getAllEvents().stream()
                    .filter(e -> e.getId() == eventId)
                    .findFirst()
                    .orElse(null);

            if (event != null) {
                double amount = event.getPrice() * numberOfSeats;
                if (paymentProcessor.processPayment(booking, amount)) {
                    System.out.println("Payment successful!");
                } else {
                    System.out.println("Payment failed! Booking will be cancelled in 10 minutes if not paid.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void cancelBooking(String customerName) {
        viewCustomerBookings(customerName);
        System.out.print("Enter booking ID to cancel: ");
        int bookingId = scanner.nextInt();
        bookingService.cancelBooking(bookingId);
        System.out.println("Booking cancelled successfully!");
    }

    private void viewCustomerBookings(String customerName) {
        List<Booking> bookings = bookingService.getCustomerBookings(customerName);
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        System.out.println("\nYour Bookings:");
        for (Booking booking : bookings) {
            System.out.printf("Booking ID: %d, Event ID: %d, Seats: %d, Paid: %s%n",
                    booking.getId(), booking.getEventId(), booking.getNumberOfSeats(),
                    booking.isPaid() ? "Yes" : "No");
        }
    }

    private void viewAllEvents() {
        List<Event> events = bookingService.getAllEvents();
        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }

        System.out.println("\nAvailable Events:");
        for (Event event : events) {
            if (event.isActive()) {
                System.out.printf("ID: %d, Name: %s, Available Seats: %d, Price: $%.2f%n",
                        event.getId(), event.getName(), event.getAvailableSeats(), event.getPrice());
            }
        }
    }

    private static int eventIdCounter = 1;
    private static int bookingIdCounter = 1;

    private static int generateEventId() {
        return eventIdCounter++;
    }

    private static int generateBookingId() {
        return bookingIdCounter++;
    }
}