package DP_Day5;

public class DebitCardPayment implements Payment{
String DebitCardNumber;
public DebitCardPayment(String DebitCardNumber) {
	this.DebitCardNumber = DebitCardNumber;
}
public void pay(double amount) {
	System.out.println("Paid " + amount + " using Debit Card: " + DebitCardNumber);
}
}
