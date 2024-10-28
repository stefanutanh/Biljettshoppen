class InvoicePayment implements PaymentProcessor {
    @Override
    public boolean processPayment(Booking booking, double amount) {
        booking.setPaid(true);
        return true;
    }
}