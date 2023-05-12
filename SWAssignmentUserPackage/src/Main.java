import Database.*;
import Ordering.*;
import Products.*;
import Users.*;

import java.util.Scanner;

public class Main {
    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        if (UsersDB.getUser() == null) { //For not-registered users
            System.out.println("1. Register a new user\n2. Log in\n3. View catalog\n4. Exit\n");
            int option = sc.nextInt();
            switch (option) {
                case 1: /*Handle register Here*/ break;
                case 2: /*Handle Login Here*/ break;
                case 3: MenuDB.viewMenu(); break;
                default:
                    System.exit(0);
            }
        } else { //For registered users
            System.out.println("1. View catalog\n2. View shopping cart\n3. Logout\n4. Exit\n");
            int option = sc.nextInt();
            switch (option) {
                case 1: MenuDB.viewMenu(); break;
                case 2: /*Handle view cart Here*/ break;
                case 3:
                    UsersDB.logout();
                    break;
                default:
                    System.exit(0);
            }
        }

        return;
    }
    public static void main(String[] args) {
        Item item1 = new Item(1, "Coke", 2, "Drink", "Coke", "Coke", "Coke", 10);
        Item item2 = new Item(2, "Pepsi", 2, "Drink", "Pepsi", "Pepsi", "Pepsi", 10);
        MenuDB.addItemToMenu(item1);
        MenuDB.addItemToMenu(item2);

        System.out.println("Welcome to Toffee Shop..\nPlease choose the option you would like to do:\n");
        while (true)
            showMenu();

    }

}