package DP_Day12;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BankAccount {

    private long accountNumber;
    private String customerName;
    private String branchName;
    private String accountType;
    private String phoneNumber;
    private double balance;

    private ArrayList<String> transactions = new ArrayList<>();

    public BankAccount(long accountNumber, String customerName,
                       String branchName, String accountType,
                       String phoneNumber, double balance) {

        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.branchName = branchName;
        this.accountType = accountType;
        this.phoneNumber = phoneNumber;
        this.balance = balance;

        transactions.add("Account Created with Balance : " + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited : " + amount);
    }

    public void withdraw(double amount) {

        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrawn : " + amount);
        }

        else {
            System.out.println("Insufficient Balance!");
            transactions.add("Failed Withdrawal : " + amount);
        }
    }

    public void saveToFile(String fileName) {

        try {

            FileWriter fw = new FileWriter(fileName);

            fw.write("========== BANK ACCOUNT DETAILS ==========\n");

            fw.write("Account Number : " + accountNumber + "\n");
            fw.write("Customer Name  : " + customerName + "\n");
            fw.write("Branch Name    : " + branchName + "\n");
            fw.write("Account Type   : " + accountType + "\n");
            fw.write("Phone Number   : " + phoneNumber + "\n");
            fw.write("Current Balance: " + balance + "\n");

            fw.write("\n========== TRANSACTION HISTORY ==========\n");

            for (String t : transactions) {
                fw.write(t + "\n");
            }

            fw.close();

            System.out.println("Account Data Saved Successfully!");

        }

        catch (IOException e) {
            System.out.println(e);
        }
    }
}