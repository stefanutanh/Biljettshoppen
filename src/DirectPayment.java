class DirectPayment implements PaymentProcessor {
    @Override
    public boolean processPayment(Booking booking, double amount) {
        // Simpel implementation av direktbetalning
        booking.setPaid(true);
        return true;
    }
}