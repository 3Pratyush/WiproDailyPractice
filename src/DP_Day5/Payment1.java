package DP_Day5;
public abstract class Payment1 {
    public final void processPayment(int amount) {
        System.out.println("Secure Processing started");
        pay(amount);
        System.out.println("Payment Successful");
    }
    public abstract void pay(int amount);
}