import Database.*;
import Ordering.*;
import Products.*;

public class Main {

    /*public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        if (userController.getCurrentUser() == null) { //For not-registered users
            System.out.println("1. Register a new user\n2. Log in\n3. View catalog\n4. Exit\n");
            int option = sc.nextInt();
            switch (option) {
                case 1: *//*Handle register Here*//* break;
                case 2: *//*Handle Login Here*//* break;
                case 3: MenuDB.viewMenu(); break;
                default:
                    System.exit(0);
            }
        } else { //For registered users
            System.out.println("1. View catalog\n2. View shopping cart\n3. Logout\n4. Exit\n");
            int option = sc.nextInt();
            switch (option) {
                case 1: MenuDB.viewMenu(); break;
                case 2: *//*Handle view cart Here*//* break;
                case 3:
                    *//*Handle logout Here*//*
                    break;
                default:
                    System.exit(0);
            }
        }
        sc.close();
        return;
    }*/
    public static void main(String[] args) {
        Item item1 = new Item( 1,"Coke", 2, "Drink", "Coke", "Coke", "Coke", 10);
        Item item2 = new Item( 2,"Pepsi", 2, "Drink", "Pepsi", "Pepsi", "Pepsi", 10);
        MenuDB.addItemToMenu(item1);
        MenuDB.addItemToMenu(item2);
        MenuDB.removeItemFromMenu(2);
        MenuDB.viewMenu();
        ShoppingCart sc = new ShoppingCart();
        sc.addItem(item1, 2);
        sc.addItem(item2, 3);
        OrdersDB.addOrder(sc);
        OrdersDB.viewOrder();
        OrdersDB.setOrderPaid(true);
        OrdersDB.viewOrder();
        OrdersDB.delOrder();


    }

}