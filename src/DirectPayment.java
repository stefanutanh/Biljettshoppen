class DirectPayment implements PaymentProcessor {
    @Override
    public boolean processPayment(Booking booking, double amount) {
        // Simple direct payment implementation
        booking.setPaid(true);
        return true;
    }
}


 //   implementation of payment processors (Following Open/Closed Principle)