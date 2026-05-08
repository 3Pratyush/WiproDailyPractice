package DP_Day5;

public interface Payment {
void pay(double payment);
default void paymentStatus() {
	System.out.println("You payment is successful.");
}
}
