import Users.Admin;
import Products.Menu;
import Users.Customer;
import Users.RegisteredCustomer;
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("ziad", 20210153, "exampleTest2", "123456789");
        customer.register("ziad", "123456789","streetY", "01234567891");
        Admin saif = new Admin ( "saif", 20210165, "exampleTest2", "123456789");
        saif.register("saif", "123456789","streetY", "01234567891");
        saif.logIn("exampleTest2", "123456789");
        System.out.println("Is logged in: " + saif.logIn("exampleTest2", "123456789"));

        boolean isLoggedIn = RegisteredCustomer.logIn("ziad", "123456789");
        System.out.println("Is logged in: " + isLoggedIn);
    }

}