public class Direktbetalning implements Betalningsmetod {
    @Override
    public void betala(double belopp) {
        System.out.println("En direktbetalning av " + belopp + " kronor är genomförd.");
    }
}