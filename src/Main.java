public class Main {
    public static void main(String[] args) {
        //Skapa betalningsmetoder
        Betalningsmetod direktbetalning = new Direktbetalning();
        Betalningsmetod faktura = new Faktura();

        //Gör en betalning
        direktbetalning.betala(300.0);
        faktura.betala(350.0);

        Event event = new Event("2024-10-30", "19:00", 10);

        event.displaySeats();

        if (event.bookSeats(3)) {
            direktbetalning.betala(300.0);
        }

        event.displaySeats();
        if (event.bookSeats(2)) {
            faktura.betala(350.0);
        }

        event.displaySeats();

    }
}
