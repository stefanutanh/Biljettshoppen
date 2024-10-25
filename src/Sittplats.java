public class Sittplats {
    private boolean booked;
    private String type; //fällplats eller bänk

    public Sittplats(String type) {
        this.booked = false;
        this.type = type;
    }

    public boolean isBooked() {
        return booked;
    }

    public void book() {
        this.booked = true;
    }

    public String getType() {
        return type;
    }
}
