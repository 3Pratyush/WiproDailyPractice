package DP_Day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BankingSystem {

    public static void main(String[] args) {

        BankAccount account =
                new BankAccount(
                        123456789,
                        "Pratyush",
                        "Kolkata Branch",
                        "Savings",
                        "9876543210",
                        10000
                );

        account.deposit(5000);
        account.withdraw(2000);
        account.deposit(3000);
        account.withdraw(1500);

        String fileName = "bankdata.txt";

        account.saveToFile(fileName);

        try {

            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;

            System.out.println("\n========== READING DATA FROM FILE ==========\n");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        }

        catch (IOException e) {
            System.out.println(e);
        }
    }
}