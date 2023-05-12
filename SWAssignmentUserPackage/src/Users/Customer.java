package Users;
import Products.Menu;
import Products.Item;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Customer extends User {
    private Menu menu;
    private boolean suspended = false;

    public Customer(String name, int id, String email, String password) {
        super(name, id, email, password, "Customer");
        this.menu = new Menu();
    }

    public void register(String username,String password ,String address, String Phone) {
            String userData = username + " | "+ password + " | " + address + " | " + Phone ;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("CustomersData.txt", true))) {
                writer.write(userData);
                writer.newLine();
                System.out.println("User registered successfully.");
            } catch (IOException e) {
            System.out.println("Error writing user data: " + e.getMessage());
        }
    }
    public void addItem(Item item) {
        menu.addItemToMenu(item);
    }

    public void enterOTP(int otp) {
        //implementation
    }

    public Item searchByItem(String itemName) {
        Item items[] = menu.getItems();
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public Item searchByCategory(String categoryName) {
        Item items[] = menu.getItems();
        for (Item item : items) {
            if (item.getCategory().equals(categoryName)) {
                return item;
            }
        }
        return null;
    }

    public void setSuspended(boolean b) {
        suspended = b;
    }
}