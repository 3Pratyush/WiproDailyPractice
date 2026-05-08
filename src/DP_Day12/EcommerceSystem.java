package DP_Day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EcommerceSystem {

    public static void main(String[] args) {

        Order order = new Order(
                101,
                "Pratyush",
                "Laptop",
                1,
                65000,
                "Kolkata, West Bengal",
                "Credit Card",
                "Shipped",
                "15-May-2026"
        );

        String fileName = "orderdata.txt";

        // Save order details into file
        order.saveOrder(fileName);

        // Read order details from file
        try {

            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;

            System.out.println("\n========== READING ORDER DATA ==========\n");

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