
import Database.*;
import Ordering.*;
import Products.*;
import Users.*;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        if (UsersDB.getUser() == null) { //For not-registered users
            System.out.println("1. Register a new user\n2. Log in\n3. View catalog\n4. Exit\n");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    String username , password , address , phone,email ;
                    System.out.println("enter your username : ");
                    username = sc.next();
                    System.out.println("enter your password : ");
                    password = sc.next();
                    System.out.println("enter your address : ");
                    address = sc.next();
                    System.out.println("enter your email : ");
                    email = sc.next();
                    System.out.println("enter your phone number : ");
                    phone = sc.next();
                    Customer newCustomer = new Customer(username,1,email , address,password);
                    newCustomer.register(username,password,address,phone);
                    String otp = newCustomer.OTPGenerator();
                    if (newCustomer.sendOTP(username , email,otp)) {
                        System.out.println("enter the sent OTP");
                        String sentOTP = sc.next();
                        if (Objects.equals(sentOTP, otp))
                            System.out.println("Registration is completed");
                        else
                            System.out.println("invalid OTP, failed to register");
                     }
                    break;
                case 2:
                    String loginUsername , loginPassword;
                    System.out.println("enter your username : ");
                    loginUsername = sc.next();
                    System.out.println("enter your password : ");
                    loginPassword = sc.next();
                    RegisteredCustomer rg = new RegisteredCustomer();
                    if (rg.logIn(loginUsername,loginPassword)){
                        CartDB cart = new CartDB();
                        cart.viewCart();

                    }

                    else
                        System.out.println("failed");

                    break;
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