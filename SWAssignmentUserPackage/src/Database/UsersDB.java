package Database;

import Users.Customer;
import Users.User;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsersDB {
    private static User user;

    public static User getUser() {
        return user;
    }

    public static void logout(){
        user = null;
    }
}
