package DP_Day7;

class OrderProcessing implements Runnable {
    public void run() {
        System.out.println("Order is being processed...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Order processed successfully!");
    }
}
class PaymentProcessing implements Runnable {
    public void run() {
        System.out.println("Payment is being processed...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Payment processed successful!");
    }
}
class Notification implements Runnable {
    public void run() {
        System.out.println("Sending notification...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Notification sent!");
    }
}
public class FoodDelivery {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 4; i++) {
            Thread t1 = new Thread(new OrderProcessing());
            Thread t2 = new Thread(new PaymentProcessing());
            Thread t3 = new Thread(new Notification());
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        }
    }
}