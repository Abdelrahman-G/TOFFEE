package Managers;

import Ordering.Order;
import Ordering.ShoppingCart;

public class OrdersManager {
    private static Order order;


    public static void addOrder(ShoppingCart cart) {
        order = new Order(cart);
        order.setPaid(true);
    }

    public boolean isOrderDelivered() {
        return order.isDelivered();
    }

    public void setOrderDelivered(boolean isDelivered) {
        order.setDelivered(isDelivered);
    }

    public static void viewOrder() {
        order.getOrderInfo();
    }

    public static void delOrder() {
        if (order != null && order.isPaid()) {
            order.setDelivered(true);
            System.out.println("Order closed successfully.");
        } else {
            System.out.println("Something went wrong, please try again after checking that all right.");
        }
    }
}
