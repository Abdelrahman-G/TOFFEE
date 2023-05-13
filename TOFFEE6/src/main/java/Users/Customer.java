package Users;
import Products.Menu;
import Products.Item;

import java.io.FileWriter;
import java.io.IOException;

public class Customer extends User {
    private Menu menu;

    public Customer(){
        super();
        this.menu = new Menu();
    }

    public void register(String username,String password ,String address, String Phone)  {
            String userData = username + " | "+ password + " | " + address + " | " + Phone ;

            try{
                FileWriter fWriter = new FileWriter ("CustomersData.txt");
                fWriter.write(userData);
                fWriter.close();
            }
            catch (IOException e) {
            System.out.println("Error writing user data: " + e.getMessage());
        }
    }
    public void addItem(Item item) {
        menu.addItem(item.getItemID(),item);
    }



}