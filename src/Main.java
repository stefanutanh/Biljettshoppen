import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            TicketSystem system = new TicketSystem();
            Scanner scanner = new Scanner(System.in);

            // Skapa test-evenemang (släpps direkt för testning)
            Event concert = new Event(
                    "Sommarkonsert 2024",
                    LocalDateTime.now().minusMinutes(1), // Redan släppt
                    BuildingType.BRICK,
                    10
            );
            system.addEvent("EVENT1", concert);

            // Starta en separat tråd för att kontrollera utgångna bokningar
            Thread cleanupThread = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(30000); // Kontrollera var 30:e sekund
                        system.cleanupExpiredBookings();
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            });
            cleanupThread.setDaemon(true);
            cleanupThread.start();

            while (true) {
                System.out.println("\n=== Biljettbokningssystem ===");
                System.out.println("1. Visa platskarta");
                System.out.println("2. Boka biljetter");
                System.out.println("3. Betala bokning");
                System.out.println("4. Avsluta");
                System.out.print("Välj ett alternativ (1-4): ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Rensa bufferten

                switch (choice) {
                    case 1:
                        // Visa platskarta
                        Event event = system.getEvent("EVENT1");
                        if (event != null) {
                            System.out.println("\nPlatskarta:");
                            Map<String, Seat> seats = event.getSeatsMap();
                            for (Map.Entry<String, Seat> entry : seats.entrySet()) {
                                System.out.printf("%s (%s): %s%n",
                                        entry.getKey(),
                                        entry.getValue().getType(),
                                        entry.getValue().isBooked() ? "Upptagen" : "Ledig"
                                );
                            }
                        }
                        break;

                    case 2:
                        // Boka biljetter
                        System.out.print("\nAnge ditt användar-ID: ");
                        String userId = scanner.nextLine();
                        Booking booking = system.createBooking(userId, "EVENT1");

                        if (booking != null) {
                            System.out.println("Ange platsnummer att boka (t.ex. SEAT-1): ");
                            String seatId = scanner.nextLine();
                            if (system.addSeatToBooking(userId, seatId)) {
                                System.out.println("Bokning lyckades! Du har 10 minuter på dig att betala.");
                            } else {
                                System.out.println("Bokning misslyckades! Platsen kan vara upptagen eller så har du nått maxgränsen.");
                            }
                        } else {
                            System.out.println("Kunde inte skapa bokning! Kontrollera att biljettsläppet har börjat.");
                        }
                        break;

                    case 3:
                        // Betala bokning
                        System.out.print("\nAnge ditt användar-ID: ");
                        userId = scanner.nextLine();
                        System.out.println("Välj betalningsmetod (1 för direkt, 2 för faktura): ");
                        int paymentChoice = scanner.nextInt();
                        PaymentMethod method = (paymentChoice == 1) ?
                                PaymentMethod.DIRECT : PaymentMethod.INVOICE;
                        system.processPayment(userId, method);
                        break;

                    case 4:
                        System.out.println("Avslutar programmet...");
                        cleanupThread.interrupt();
                        scanner.close();
                        return;

                    default:
                        System.out.println("Ogiltigt val!");
                }
            }
        }

    }

