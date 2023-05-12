package Ordering;

import java.util.Map;

import Products.Item;
import Users.Customer;

public class Order {
    private Map<Item, Integer> items;
    private double totalCost;
    private boolean isPaid;
    private boolean isDelivered;
    private String Date;
    private Customer customer;
    private ShoppingCart cart;

    int orderID;

    public Order(Map<Item, Integer> items, double totalCost) {
        this.items = items;
        this.totalCost = totalCost;
    }
    public Order(ShoppingCart cartt) {
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
        System.out.println("Order Items: " + items);
        System.out.println("Order Total Cost: " + totalCost);
        System.out.println("Order Paid: " + isPaid);
        System.out.println("Order Delivered: " + isDelivered);
    }

}
