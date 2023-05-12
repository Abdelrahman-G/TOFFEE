package Products;

import Products.Item;

import java.util.ArrayList;
import java.util.List;
public class Menu {
    private static int menuID = 0; // unique
    private Item[] items;

    public Menu() {
        menuID++;
        this.menuID = menuID;
        items = new Item[0];
    }

    public int getMenuID() {
        return menuID;
    }
    public Item[] getItems() {

        return items;
    }

    public void addItemToMenu(Item item) {
        // create a new array with increased length
        Item[] newItems = new Item[items.length + 1];
        // copy existing items into new array
        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }
        // add new item to the end of new array
        newItems[items.length] = item;
        // replace old array with new array
        items = newItems;
    }

    public void removeItemFromMenu(int itemID) {
        // search for item with given ID
        for (int i = 0; i < items.length; i++) {
            if (items[i].getItemID() == itemID) {
                // create a new array with decreased length
                Item[] newItems = new Item[items.length - 1];
                // copy existing items into new array, except for the item to be removed
                for (int j = 0; j < i; j++) {
                    newItems[j] = items[j];
                }
                for (int j = i; j < items.length - 1; j++) {
                    newItems[j] = items[j + 1];
                }
                // replace old array with new array
                items = newItems;
                return; // exit method once item is removed
            }
        }
        // if item not found, throw an exception
        throw new IllegalArgumentException("Item not found in menu");
    }

    public void updateMenuItemInfo(int itemID, String name, int price, String category, String description, String brand, String discountCode, int quantity) {
        // search for item with given ID
        for (int i = 0; i < items.length; i++) {
            if (items[i].getItemID() == itemID) {
                // update item information
                items[i].setName(name);
                items[i].setPrice(price);
                items[i].setCategory(category);
                items[i].setDescription(description);
                items[i].setBrand(brand);
                items[i].setDiscountCode(discountCode);
                items[i].setQuantity(quantity);
                return; // exit method once item is updated
            }
        }
        // if item not found, throw an exception
        throw new IllegalArgumentException("Item not found in menu");
    }
}
