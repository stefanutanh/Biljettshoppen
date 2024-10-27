interface PaymentProcessor {
    boolean processPayment(Booking booking, double amount);
}


// Interface for Payment (Following Interface Segregation Principle)