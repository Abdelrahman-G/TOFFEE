package Users;
import Products.Menu;
import Products.Item;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Random;

public class Customer extends User {
    private Menu menu;
    private boolean suspended = false;

    public Customer(String name, int id, String email, String address, String password) {
        super(name, id, email, password, address,"Customer");
        this.menu = new Menu();
    }

    public Customer(){
        super();

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
        menu.addItemToMenu(item);
    }
    public String OTPGenerator() {
        Random random = new Random();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    public Boolean sendOTP(String curr_user, String email, String otp){

        boolean flag = false;
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");

        // Sender's email and password
        String username = "abdelrahmangomaa3005";
        String password = "yoovgzfryvkniomo";

        // Creating Session Object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setFrom(new InternetAddress("abdelrahmangomaa3005@gmail.com"));

            message.setSubject("Welcome to Toffee Store! Confirm Your Account with OTP");
            String msg = "Dear " + curr_user + "," +
                    "\n" +
                    "We're excited to welcome you to Toffee Store " +
                    "and thank you for registering with us! To complete your account registration, " +
                    "Please use the following OTP to verify your account: " + otp +
                    "\n\nThank you for choosing Toffee Store." +
                    " We look forward to providing you with the best possible shopping experience.\n\n" +
                    "Toffee Store Team";
            message.setText(msg);
            Transport.send(message);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }


    public Item searchByItem(String itemName) {
        Item items[] = menu.getItems();
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public Item searchByCategory(String categoryName) {
        Item items[] = menu.getItems();
        for (Item item : items) {
            if (item.getCategory().equals(categoryName)) {
                return item;
            }
        }
        return null;
    }

    public void setSuspended(boolean b) {
        suspended = b;
    }
}