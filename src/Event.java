class Event {
    private int id;
    private String name;
    private String building;  // "WOOD" eller "BRICK"
    private int totalSeats;
    private int availableSeats;
    private double price;
    private boolean isActive;

    // Constructor
    public Event(int id, String name, String building, int totalSeats, double price) {
        this.id = id;
        this.name = name;
        this.building = building;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.price = price;
        this.isActive = true;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAvailableSeats() { return availableSeats; }
    public double getPrice() { return price; }
    public boolean isActive() { return isActive; }

    public void setAvailableSeats(int seats) {
        this.availableSeats = seats;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }
}
