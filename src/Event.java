import java.util.ArrayList;
import java.util.List;

public class Event {
    private String date;
    private String time;
    private List<Sittplats> sittplats;
    private int maxTicketsPerPerson = 5;

    public Event(String date, String time, int numberOfSeats) {
        this.date = date;
        this.time = time;
        this.sittplats = new ArrayList<Sittplats>();
        for (int i = 0; i < numberOfSeats; i++) {
            String seatType = (i % 2 == 0) ? "fällstol" : "bänk";
            sittplats.add(new Sittplats(seatType));
        }
    }
    public boolean bookSeats(int numberOfSeats) {
        if (numberOfSeats > maxTicketsPerPerson) {
            return false; //Max 5 biljetter per person
        }
        int bookedSeats = 0;
        for (Sittplats sittplatser : sittplats) {
            if (!sittplatser.isBooked()) {
                sittplatser.book();
                bookedSeats++;
                if (bookedSeats == numberOfSeats) {
                    return true;
                }
            }
        }
        return false;
    }

    public void displaySeats() {
        for (Sittplats sittplatser : sittplats) {
            System.out.print(sittplatser.isBooked() ? "X " : "O");
        }
        System.out.println();
    }
}
