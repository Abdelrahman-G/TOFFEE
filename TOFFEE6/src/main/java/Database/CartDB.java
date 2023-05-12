package Database;

import Ordering.ShoppingCart;
import Products.Item;
import Database.OrdersDB;

import java.util.Map;
import java.util.Scanner;

public class CartDB {
    private ShoppingCart cart;
    private  int LOOSE_MAX = 10, PACKAGE_MAX = 15;
    private OrdersDB orderDB;

    public void CartController() {
        cart = new ShoppingCart();
        orderDB = new OrdersDB();
    }

    public void addItemToCart(Item item, int quantity) {
        int oldQuantity = 0, maxQuantity = (item.isLoose() == true ? LOOSE_MAX : PACKAGE_MAX);
        if (cart.getItems().containsKey(item))
            oldQuantity = cart.getItems().get(item);

        if (quantity < 0) {
            System.out.println("Invalid quantity, please enter a positive quantity.\n");
            return;
        }

        if (quantity + oldQuantity > maxQuantity) {
            cart.addItem(item, maxQuantity - oldQuantity);
            cart.setCartPrice(cart.getCartPrice() + item.getPrice() * (maxQuantity - oldQuantity));
            System.out.println("The maximum quantity allowed for this product is: " + maxQuantity
                    + ", your cart contains the amount now.\n");
            return;
        }

        cart.addItem(item, quantity);
        cart.setCartPrice(cart.getCartPrice() + item.getPrice() * quantity);
        System.out.println("Added " + quantity + "x " + item.getName() + " to cart.\n");
        displayCart();
    }

    public void removeItem(Item item, int quantity) {
        int oldQuantity = cart.getItems().get(item);

        if (quantity < 0) {
            System.out.println("Invalid quantity, please enter a positive quantity.\n");
            return;
        }

        if (oldQuantity - quantity < 0) {
            cart.getItems().remove(item);
            cart.setCartPrice(cart.getCartPrice() -  item.getPrice() * oldQuantity);
            System.out.println("The whole product has been removed from your cart.\n");
            return;
        }

        cart.getItems().remove(item);
        cart.addItem(item, oldQuantity - quantity);
        cart.setCartPrice(cart.getCartPrice() - Item.getPrice() * quantity);
        System.out.println("Removed " + quantity + "x " + Item.getName() + " from your cart.\n");
        displayCart();
    }

    public void removeFromCart() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the item's index in the shopping cart:\n");
        int ind = sc.nextInt();
        if (ind > cart.getItems().size() || ind < 1) {
            System.out.println("That item does not exist.\n");
            return;
        }
        int index = 1;
        Item itemToRemove = null;
        for (Map.Entry item : getCartItems().entrySet()) {
            if (index++ != ind)continue;
            itemToRemove = (Item) item;
        }
        sc.next();
        System.out.println("Enter the quantity you would like to remove:\n");
        int quantity = sc.nextInt();
        removeItem(itemToRemove, quantity);
    }
    public void viewCart() {
        displayCart();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Remove item from cart\n2. Place order\n3. Back to main menu\n4. Exit\n");
        int option = sc.nextInt();
        switch (option) {
            case 1: removeFromCart(); break;
            case 2: placeOrder(); break;
            case 3: break;
            default:
                System.exit(0);
        }
    }

    public Map<Item, Integer> getCartItems() {
        return cart.getItems();
    }

    public void displayCart() {
        System.out.println("Index - Name - Quantity - Price\n");
        int index = 1;
        for (Map.Entry item : getCartItems().entrySet()) {
            String name = ((Item) item.getKey()).getName();
            int quantity = ((Integer) item.getValue());
            double price = ((Item) item.getKey()).getPrice();
            System.out.println(index++ + " - " + name + " - " + quantity + " - " + price * quantity + "\n");
        }

        System.out.println("Total: " + cart.getCartPrice());
    }

    public void placeOrder() {
        orderDB.addOrder(cart.getItems(), cart.getCartPrice());
        System.out.println("Order placed.");
    }

    public boolean isOrderPaid() {
        return orderDB.isOrderPaid();
    }

    public void setOrderPaid(boolean isPaid) {
        orderDB.setOrderPaid(isPaid);
    }

    public boolean isOrderDelivered() {
        return orderDB.isOrderDelivered();
    }

    public void setOrderDelivered(boolean isDelivered) {
        orderDB.setOrderDelivered(isDelivered);
    }
}