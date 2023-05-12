package Database;
import Ordering.Order;
import Ordering.ShoppingCart;
import Products.Item;
import java.util.Map;
public class OrdersDB {
    private static Order order;

    public static void addOrder(Map<Item, Integer> cartItems, double cartTotal) {
        order = new Order(cartItems, cartTotal);
    }
    public static void addOrder(ShoppingCart cart) {
        order = new Order(cart);
    }
    public boolean isOrderDelivered() {
        return order.isDelivered();
    }
    public boolean isOrderPaid() {
        return order.isPaid();
    }
    public void setOrderDelivered(boolean isDelivered) {
        order.setDelivered(isDelivered);
    }
    public static void setOrderPaid(boolean isPaid) {
        order.setPaid(isPaid);
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
