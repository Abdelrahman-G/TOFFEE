import Users.Admin;
import Users.Menu;
import Users.Customer;
import Users.RegisteredCustomer;
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("ziad", 20210153, "exampleTest2", "123456789");
        customer.register("ziad", "123456789","streetY", "01234567891");

        boolean isLoggedIn = RegisteredCustomer.logIn("ziad", "123456789");
        System.out.println("Is logged in: " + isLoggedIn);
    }

}