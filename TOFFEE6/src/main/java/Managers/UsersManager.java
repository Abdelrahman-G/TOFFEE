package Managers;

import Users.RegisteredCustomer;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class UsersManager {
    static ArrayList<RegisteredCustomer> systemUsers = new ArrayList<RegisteredCustomer>();
    public UsersManager() {
        ReadFileToSystem();
    }
    static RegisteredCustomer currentUser = null;

    public static String otpGenerator() {
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }


    public static boolean sendOTP(String currUser, String email, String otp) {
        boolean success = false;
        final String username = "toffeeassignex1";
        final String password = "tecxqzssauonedzq";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("toffeeassignex1@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Welcome to Toffee Store! Confirm Your Account with OTP");
            String msg = "Dear " + currUser + ",\n\n"
                    + "Please use the following OTP to verify your account: " + otp;
            message.setText(msg);

            Transport.send(message);
            success = true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static boolean verifyOTP (String otp , String systemOTP) {
        return Objects.equals(otp, systemOTP);
    }
    public static void addUser() {
        Scanner sc = new Scanner(System.in);
        //RegisteredCustomer(String uName,  String passWord, String eMail, String uPhone )
        String username, password, email, phone;
        while (true) {
            System.out.println("Enter your username : ");
            username = sc.next();
            if (!isUsername(username)) {
                System.out.println("Username must be at least 5 characters long");
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("Enter your password : ");
            password = sc.next();
            if (!isPassword(password)) {
                System.out.println("Password must be at least 8 characters long");
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("Enter your email : ");
            email = sc.next();
            if (!checkEmail(email)) {
                System.out.println("Invalid email");
            } else {
                break;
            }
        }
        while (true) {
            String systemOTP = otpGenerator() , otp;
            sendOTP(username,email, systemOTP);
            System.out.println("please enter OTP sent to this email " + email);
            otp = sc.next();
            if (verifyOTP(otp , systemOTP)){
                System.out.println("email is verified");
                break;
            }
            else {
                System.out.println("WRONG OTP");
                System.exit(0);
            }
        }

        while (true) {
        System.out.println("Enter your phone : ");
        phone = sc.next();

            if (!isPhoneNumber(phone)) {
                System.out.println("Invalid Phone");
            } else {
                break;
            }
    }
        RegisteredCustomer newUser = new RegisteredCustomer(username, password, email, phone);
        writeIntoFile(username,password,email,phone);
        systemUsers.add(newUser);
        System.out.println("User added successfully");
    }


    private static boolean isUsername(String username) {
        if (username.length() >= 5) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isPassword(String password) {
        if (password.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isPhoneNumber(String phoneNumber) {
        String regex = "^01[1250]\\d{8}$";
        return phoneNumber.matches(regex);
    }
    private static boolean checkEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static void writeIntoFile(String username, String password, String email, String Phone)  {
        String userData = username + " | "+ password + " | " + email + " | " + Phone;
        try{
            FileWriter fWriter = new FileWriter ("CustomersData.txt", true);
            fWriter.write(userData + "\n");
            fWriter.close();
        }
        catch (IOException e) {
            System.out.println("Error writing user data: " + e.getMessage());
        }
    }
    public void ReadFileToSystem (){
        String filename = "CustomersData.txt";

        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");

                String username = parts[0].trim();
                String password = parts[1].trim();
                String email = parts[2].trim();
                String phone = parts[3].trim();

                RegisteredCustomer customer = new RegisteredCustomer(username, password, email, phone);
                systemUsers.add(customer);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }



    public RegisteredCustomer verifyLogIn() {
        Scanner sc = new Scanner(System.in);
        String loginUsername, loginPassword;
        System.out.println("Enter your username : ");
        loginUsername = sc.next();
        System.out.println("Enter your password : ");
        loginPassword = sc.next();
        for (int i = 0; i < systemUsers.size(); i++) {
            if (systemUsers.get(i).getUsername().equals(loginUsername) && systemUsers.get(i).getPassword().equals(loginPassword)) {
                currentUser = systemUsers.get(i);
                break;
            }
        }
        if (currentUser != null) {
            System.out.println("Successful login");

        } else {
            System.out.println("Falied login");
            return null;
        }
        return currentUser;
    }

    public static RegisteredCustomer getUser() {
        return currentUser;
    }

    public static void logout(){
        currentUser = null;
    }
}
