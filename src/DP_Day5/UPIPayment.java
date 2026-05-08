package DP_Day5;

public class UPIPayment implements Payment{
String upiID;
public UPIPayment(String upiID) {
	this.upiID = upiID;
}
public void pay(double amount) {
	System.out.println("Paid " + amount + " using UPI: " + upiID);
}
}
