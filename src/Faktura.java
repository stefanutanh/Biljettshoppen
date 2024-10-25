public class Faktura implements Betalningsmetod {
    @Override
    public void betala(double belopp) {
        System.out.println("En faktura på " + belopp + " kronor är skickad till dig.");
    }
}
