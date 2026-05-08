package DP_Day12;

import java.io.FileWriter;
import java.io.IOException;

public class Order {

    private int orderId;
    private String customerName;
    private String productName;
    private int quantity;
    private double totalPrice;
    private String shippingAddress;
    private String paymentMethod;
    private String orderStatus;
    private String deliveryDate;

    public Order(int orderId, String customerName,
                 String productName, int quantity,
                 double totalPrice, String shippingAddress,
                 String paymentMethod, String orderStatus,
                 String deliveryDate) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.orderStatus = orderStatus;
        this.deliveryDate = deliveryDate;
    }

    public void saveOrder(String fileName) {

        try {

            FileWriter fw = new FileWriter(fileName);

            fw.write("========== ORDER DETAILS ==========\n");

            fw.write("Order ID         : " + orderId + "\n");
            fw.write("Customer Name    : " + customerName + "\n");
            fw.write("Product Name     : " + productName + "\n");
            fw.write("Quantity         : " + quantity + "\n");
            fw.write("Total Price      : " + totalPrice + "\n");
            fw.write("Shipping Address : " + shippingAddress + "\n");
            fw.write("Payment Method   : " + paymentMethod + "\n");
            fw.write("Order Status     : " + orderStatus + "\n");
            fw.write("Delivery Date    : " + deliveryDate + "\n");

            fw.close();

            System.out.println("Order Saved Successfully!");

        }

        catch (IOException e) {
            System.out.println(e);
        }
    }
}