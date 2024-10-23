public class Faktura implements Betalningsmetod {
    @Override
    public void betala(double belopp) {
        System.out.println("Faktura på " + belopp + " kronor skickad.");
    }
}
