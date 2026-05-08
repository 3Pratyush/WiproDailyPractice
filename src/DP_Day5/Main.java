package DP_Day5;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double bankBalance = 10000.0;
        double creditBalance = 20000.0;
        System.out.println("Enter amount to pay:");
        double amount = sc.nextDouble();
        int choice = 0;
        while (choice < 1 || choice > 3) {
            System.out.println("Please choose your payment method:");
            System.out.println("1. Credit Card");
            System.out.println("2. UPI");
            System.out.println("3. Debit Card");
            choice = sc.nextInt();
            if (choice == 1) {
                if (amount > creditBalance) {
                    System.out.println("Credit limit exceeded!");
                } else {
                    System.out.println("Enter Credit Card Number:");
                    sc.nextLine();
                    String creditCard = sc.nextLine();
                    Payment payment = new CreditCardPayment(creditCard);
                    payment.pay(amount);
                    payment.paymentStatus();
                    creditBalance -= amount;
                    System.out.println("Remaining Credit Balance: " + creditBalance);
                }
            } 
            else if (choice == 2) {
                if (amount > bankBalance) {
                    System.out.println("Insufficient bank balance!");
                } else {
                    System.out.println("Please enter your UPI ID:");
                    sc.nextLine();
                    String upi = sc.nextLine();
                    Payment payment = new UPIPayment(upi);
                    payment.pay(amount);
                    payment.paymentStatus();
                    bankBalance -= amount;
                    System.out.println("Remaining Bank Balance: " + bankBalance);
                }
            } 
            else if (choice == 3) {
                if (amount > bankBalance) {
                    System.out.println("Insufficient bank balance!");
                } else {
                    System.out.println("Please enter your debit card number:");
                    sc.nextLine();
                    String debitCard = sc.nextLine();
                    Payment payment = new DebitCardPayment(debitCard);
                    payment.pay(amount);
                    payment.paymentStatus();
                    bankBalance -= amount;
                    System.out.println("Remaining Bank Balance: " + bankBalance);
                }
            } 
            else {
                System.out.println("Invalid choice! Please try again.\n");
            }
        }
        sc.close();
    }
}