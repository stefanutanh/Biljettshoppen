public class Direktbetalning implements Betalningsmetod {
    @Override
    public void betala(double belopp) {
        System.out.println("Direktbetalning av " + belopp + " kronor genomförd.");
    }
}