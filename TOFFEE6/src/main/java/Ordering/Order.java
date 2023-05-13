package Ordering;

import Products.Item;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Order {
    private Map<Item, Integer> items;
    private double totalCost;
    private boolean isPaid;
    private boolean isDelivered;

    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String currentDateString = currentDate.format(formatter);
    private String Date = currentDateString;

    private ShoppingCart cart;

    private static int orderID = 0;

    public Order() {
        this.orderID = ++orderID;
    }

    public Order(ShoppingCart cartt) {
        this.orderID = ++orderID;
        this.cart = cartt;
    }

    public double getTotalOrderPrice() {
        return totalCost;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    public int getId() {
        return orderID;
    }

    public String getDate() {
        return Date;
    }

    public void getOrderInfo() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Order Date: " + Date);

    }

}
