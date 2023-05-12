package Ordering;
import Products.Item;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    public static Map<Item, Integer> scItems = new HashMap<>();
    private double cartPrice = 0;


    public static Map<Item, Integer> getItems() {
        return scItems;
    }


    public static void addItem(Item item, int quantity) {
        scItems.put(item, quantity);
    }

    public double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(double cartPrice) {
        this.cartPrice = cartPrice;
    }

}
