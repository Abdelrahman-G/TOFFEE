package Database;

import Users.Customer;
import Users.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UsersDB {
    ArrayList<RegisteredCustomer> users = new ArrayList<RegisteredCustomer>();

    private void loadUsers () {

    }
    Scanner sc = new Scanner(System.in);
    RegisteredCustomer rg = new RegisteredCustomer();
    private boolean isValidUsername(String username) {
        return username.length() >= 3;
    }
    private boolean isValidPassword(String password) {
        return password.length() >= 8;
    }
    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public RegisteredCustomer verifyLogIn() {
        String loginUsername , loginPassword;
        System.out.println("enter your username : ");
        loginUsername = sc.next();
        System.out.println("enter your password : ");
        loginPassword = sc.next();

        if (!Objects.equals(rg.logIn(loginUsername, loginPassword), null)){

            System.out.println("successful login");
            System.out.println(rg.getName());
            return rg;
        }

        else {
            System.out.println("failed");
            return null;
        }

    }

//    public static RegisteredCustomer getUser() {
//        return rg;
//    }
//
//    public static void logout(){
//        rg = null;
//    }
}
