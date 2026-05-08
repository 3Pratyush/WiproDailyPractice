package DP_Day5;
public class Payment2 extends Payment1 {
    @Override
    public void pay(int amount) {
        System.out.println("Processing payment: " + amount);
    }
    public static void main(String[] args) {
        Payment2 obj = new Payment2();
        obj.processPayment(1000);
    }
}
