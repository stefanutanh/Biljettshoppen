public class Main {
    public static void main(String[] args) {
        Betalningsmetod direktbetalning = new Direktbetalning();
        Betalningsmetod faktura = new Faktura();

        direktbetalning.betala(100.0);
        faktura.betala(200.0);
    }
}
