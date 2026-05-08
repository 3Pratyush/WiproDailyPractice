package DP_Day6;
import java.util.Scanner;

interface ATMOperations {
    void enterPIN(int pin) throws Exception;
}

class ATM implements ATMOperations {
    private int correctPIN = 1234;

    public void enterPIN(int pin) throws Exception {
        if (pin != correctPIN) {
            throw new Exception();
        }
        System.out.println("PIN Verified Successfully");
    }
}

public class ATMTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        try {
            System.out.print("Insert Card");
            System.out.print("\nEnter your- ATM PIN: ");
            int pin = sc.nextInt();
            atm.enterPIN(pin);
        } catch (Exception e) {
            System.out.println("Incorrect PIN! Access Denied");
        } finally {
            System.out.println("Transaction Logged");
            sc.close();
        }
    }
}