package DP_Day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FoodDeliverySystem {

    public static void main(String[] args) {

        FoodOrder order = new FoodOrder(
                501,
                "Pratyush",
                "9876543210",
                "Pizza Hub",
                "Rahul",
                "Kolkata, West Bengal",
                "Cash On Delivery",
                "07-May-2026",
                "45 Minutes",
                850,
                50,
                "Delivered"
        );

        order.addItem("Cheese Pizza");
        order.addItem("Burger");
        order.addItem("Cold Drink");
        order.addItem("French Fries");

        String fileName = "foodorder.txt";

        // Save order details into file
        order.saveOrderData(fileName);

        // Read order details from file
        try {

            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;

            System.out.println("\n========== READING FOOD ORDER DATA ==========\n");

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