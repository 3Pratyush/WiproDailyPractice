package DP_Day12;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FoodOrder {

    private int orderId;
    private String customerName;
    private String customerPhone;
    private String restaurantName;
    private String deliveryPartner;
    private String deliveryAddress;
    private String paymentMethod;
    private String orderDate;
    private String estimatedDeliveryTime;

    private ArrayList<String> menuItems =
            new ArrayList<>();

    private double totalAmount;
    private double deliveryCharge;
    private String deliveryStatus;

    public FoodOrder(int orderId,
                     String customerName,
                     String customerPhone,
                     String restaurantName,
                     String deliveryPartner,
                     String deliveryAddress,
                     String paymentMethod,
                     String orderDate,
                     String estimatedDeliveryTime,
                     double totalAmount,
                     double deliveryCharge,
                     String deliveryStatus) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.restaurantName = restaurantName;
        this.deliveryPartner = deliveryPartner;
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.orderDate = orderDate;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
        this.totalAmount = totalAmount;
        this.deliveryCharge = deliveryCharge;
        this.deliveryStatus = deliveryStatus;
    }

    public void addItem(String item) {
        menuItems.add(item);
    }

    public void saveOrderData(String fileName) {

        try {

            FileWriter fw = new FileWriter(fileName);

            fw.write("========== FOOD ORDER DETAILS ==========\n");

            fw.write("Order ID                : " + orderId + "\n");
            fw.write("Customer Name           : " + customerName + "\n");
            fw.write("Customer Phone          : " + customerPhone + "\n");
            fw.write("Restaurant Name         : " + restaurantName + "\n");
            fw.write("Delivery Partner        : " + deliveryPartner + "\n");
            fw.write("Delivery Address        : " + deliveryAddress + "\n");
            fw.write("Payment Method          : " + paymentMethod + "\n");
            fw.write("Order Date              : " + orderDate + "\n");
            fw.write("Estimated Delivery Time : " + estimatedDeliveryTime + "\n");
            fw.write("Total Amount            : " + totalAmount + "\n");
            fw.write("Delivery Charge         : " + deliveryCharge + "\n");
            fw.write("Delivery Status         : " + deliveryStatus + "\n");

            fw.write("\n========== ORDERED FOOD ITEMS ==========\n");

            for (String item : menuItems) {
                fw.write(item + "\n");
            }

            fw.close();

            System.out.println("Food Order Saved Successfully!");

        }

        catch (IOException e) {
            System.out.println(e);
        }
    }
}