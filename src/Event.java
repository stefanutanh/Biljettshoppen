import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Event {
    private String name;
    private LocalDateTime releaseDateTime;
    private BuildingType buildingType;
    private Map<String, Seat> seats;
    private int totalSeats;

    public Event(String name, LocalDateTime releaseDateTime, BuildingType buildingType, int totalSeats) {
        this.name = name;
        this.releaseDateTime = releaseDateTime;
        this.buildingType = buildingType;
        this.totalSeats = totalSeats;
        this.seats = new HashMap<>();
        initializeSeats();
    }

    private void initializeSeats() {
        for (int i = 1; i <= totalSeats; i++) {
            SeatType type = i % 2 == 0 ? SeatType.FOLDING_CHAIR : SeatType.BENCH;
            seats.put("SEAT-" + i, new Seat("SEAT-" + i, type));
        }
    }

    public boolean isSeatAvailable(String seatId) {
        return seats.containsKey(seatId) && !seats.get(seatId).isBooked();
    }

    public Map<String, Seat> getSeatsMap() {
        return new HashMap<>(seats);
    }

    public boolean isTicketReleased() {
        return LocalDateTime.now().isAfter(releaseDateTime);
    }

    // Getters
    public String getName() { return name; }
    public LocalDateTime getReleaseDateTime() { return releaseDateTime; }
    public BuildingType getBuildingType() { return buildingType; }
    public int getTotalSeats() { return totalSeats; }
}
