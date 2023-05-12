package Users;

public abstract class User {
    private String name;
    private int id;
    private String email;
    private String address;
    private String password;
    private String role;

    public User(String name, int id, String email, String password,String address, String role) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User() {

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public String getAddress() {
        return address;
    }

    public String getRole() {
        return role;
    }
}