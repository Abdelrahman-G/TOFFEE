package Users;
import Ordering.Order;
import Products.Menu;
import Products.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class Admin extends User{
    private Menu menu;

    public Admin(String name, int id, String email, String password) {
        super(name, id, email, password,"non", "Admin");
        this.menu = new Menu();
    }
    public void viewItems() {
        Item ItemList[] = menu.getItems();
        for (Item item : ItemList) {
            System.out.println(item.getName() + " - " +item.getPrice());
        }
    }

    public boolean logIn(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("AdminsData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split("\\s*\\|\\s*");

                if (userData.length >= 3) {
                    String storedUsername = userData[0].trim();
                    String storedPassword = userData[1].trim();

                    if (username.equals(storedUsername) && password.equals(storedPassword)) {
                        System.out.println("Login successful.");
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user data: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid file format: " + e.getMessage());
        }

        System.out.println("Invalid username or password.");
        return false;
    }
    public void register(String username, String encryptedPassword, String userID, String userEmail) {
        String userData = username + " | " + encryptedPassword + " | " + userID + " | " + userEmail;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("AdminsData.txt", true))) {
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
    public void updateItem(int itemID,String givenName, int givenprice, String givenCategory, String givenDescription, String givenBrand, String givenDiscountCode, int givenQuantity){
        menu.updateMenuItemInfo(itemID,  givenName,  givenprice,  givenCategory,  givenDescription,  givenBrand,  givenDiscountCode,  givenQuantity);
    }
    public void deleteItem(int itemID){
        menu.removeItemFromMenu(itemID);
    }
    public void suspendCustomer(Customer customer) {
        customer.setSuspended(true);
        System.out.println("Customer suspended: " + customer.getName());
    }
    public void trackOrder(Order order) {

        int orderId = order.getId();
        String orderDate = order.getDate();

        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
    }
    public void viewState(){
        System.out.println("Admin name: " + getName());
        System.out.println("Admin id: " + getId());
        System.out.println("Admin email: " + getEmail());
        System.out.println("Admin password: " + getPassword());
        System.out.println("Admin role: " + getRole());
    }

}
