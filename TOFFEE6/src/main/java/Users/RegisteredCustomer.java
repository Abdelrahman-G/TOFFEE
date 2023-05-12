package Users;
import Ordering.*;
import Products.*;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class RegisteredCustomer extends Customer{
    private String username;
    private String address;
    private String phone;
    private boolean isActive;
    private int loyaltyPoints;
    private Order[] order;
    private Item items;
    private Payment paymentMethod;
    public RegisteredCustomer() {

    }

    public RegisteredCustomer(String name, int id, String email, String password, String username, String address,
                              String phone) {
        super(name, id, email,address, password);
        this.username = username;
        this.address = address;
        this.phone = phone;
        this.isActive = true;
        this.loyaltyPoints = 0;
        this.order = new Order[10];
        this.paymentMethod = null;
    }
    public void showInfo(){
        System.out.println("Name: " + getName());
        System.out.println("userName: " + username);
        System.out.println("ID: " + getId());
        System.out.println("Email: " + getEmail());
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("Loyalty Points: " + loyaltyPoints);
    }
    public String getLoyaltyPoints(){
        return "Loyalty Points: " + loyaltyPoints;
    }

public  boolean logIn(String username, String password) {
    try (BufferedReader reader = new BufferedReader(new FileReader("CustomersData.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] userData = line.split(" \\| ");

            if (userData.length >= 2) {
                String storedUsername = userData[0].trim();
                String storedPassword = userData[1].trim();
                System.out.println(userData[0] + " " + userData[1]);
                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    System.out.println("Login successful.");
                    return true;
                }
            }
        }
        System.out.println("Invalid username or password.");
        return false;
    } catch (IOException e) {
        System.out.println("Error reading user data: " + e.getMessage());
        return false;
    }
}

//    public void reOrder(Orders order) {
//
//    }
    public void viewShoppingCart(){
        Map<Item, Integer> map = ShoppingCart.getItems();
        for (Item key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key.getName() + " - " +key.getPrice());        }
    }

    public void addItemToCart(Item item, int quantity){
        ShoppingCart.addItem(item,quantity);
    }
//    public void checkOut(Orders order,Payment payment){
//
//    }
}
