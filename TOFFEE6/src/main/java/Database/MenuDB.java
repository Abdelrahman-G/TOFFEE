package Database;
import Products.Item;
import Products.Menu;


public class MenuDB {
    private static Menu menu = new Menu();

    public static Menu getMenu() {
        return menu;
    }

    public  static void addItemToMenu(Item item) {
        menu.addItemToMenu(item);
    }

    public static void removeItemFromMenu(int itemID) {
        menu.removeItemFromMenu(itemID);
    }

    public static void updateMenuItemInfo(int itemID, String name, int price, String category, String description, String brand, String discountCode, int quantity) {
        menu.updateMenuItemInfo(itemID, name, price, category, description, brand, discountCode, quantity);
    }

    public static void viewMenu() {
        System.out.println("Welcome to the menu!");
        for ( Item item : menu.getItems() ) {
            System.out.println(item.getItemID() + " - " + item.getName() + " , " + item.getPrice() + " , " + item.getCategory() + " , " + item.getDescription() + " , " + item.getBrand() + " , " + item.getDiscountCode() + " , " + item.getQuantity());
        }
    }
}
