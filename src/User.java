public class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.password = "123";
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}
