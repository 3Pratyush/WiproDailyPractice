package DP_Day5;

public class CreditCardPayment implements Payment {
String CreditCardNumber;
public CreditCardPayment(String CreditCardNumber) {
   this.CreditCardNumber = CreditCardNumber;
}
public void pay(double amount) {
    System.out.println("Paid " + amount + " using Credit Card: " + CreditCardNumber);
}
}
