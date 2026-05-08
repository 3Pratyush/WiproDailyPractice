package DP_Day5;

public class BankAccount {
final int AccountNumber = 123456789;
void display() {
	System.out.println("Your Account Number is:"+AccountNumber);
}
public static void main(String[] args) {
	BankAccount account = new BankAccount();
	account.display();
}
}
