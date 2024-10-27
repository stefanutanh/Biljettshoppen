import java.util.List;

interface EventManager {
    void addEvent(Event event);
    void removeEvent(int eventId);
    void updateEvent(Event event);
    List<Event> getAllEvents();
}

// Interface for Event Management (Following Interface Segregation Principle)