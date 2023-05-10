package Users;

public abstract class User {
    private String name;
    private int id;
    private String email;
    private String password;
    private String role;

    public User(String name, int id, String email, String password, String role) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
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

    public String getRole() {
        return role;
    }
}