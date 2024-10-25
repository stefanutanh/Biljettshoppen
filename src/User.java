public class User {
    private String name;
    private String email;
    private String password;

    // Konstruktor
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // Metod för att verifiera lösenord
    public boolean verifyPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    // toString metod för att kunna skriva ut användarinformation
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}