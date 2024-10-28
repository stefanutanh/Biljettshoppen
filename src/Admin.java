class Admin {
    private String password;

    public Admin(String password) {
        this.password = password;
    }

    public boolean verify(String inputPassword) {
        return this.password.equals(inputPassword);
    }
}