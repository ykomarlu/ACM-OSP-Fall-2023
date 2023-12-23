package ospbusapp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a single bus that travels along a Route, stopping at each Stop along the way
 * <p></p>
 * Contains the ID of the Stop being approached, the seconds till it arrives, and other relevant metadata
 */
public class Bus {
    // Fields that update with each batch of API data:
    // Derived directly from API data:
    private long busId; // VehicleID in API
    private long routeId; // RouteID in API
    private long nextStopId; // StopID in API of the stop currently being approached
    private List<Double> secondsTillArrival; // Seconds to arrival for each upcoming stop (index 0 is time to next stop)
    // Updated with each update:
    private LocalDateTime lastUpdated; // Record of when the bus was last updated locally

    //Constructors:
    public Bus(long busId, long routeId, long nextStopId, List<Double> secondsTillArrival) {
        this.busId = busId;
        this.routeId = routeId;
        this.nextStopId = nextStopId;
        this.secondsTillArrival = secondsTillArrival;
        this.lastUpdated = LocalDateTime.now(); //Set last updated to current time
    }

    //Methods:
    public long getBusId() {
        return busId;
    }

    public void setBusId(long busId) {
        this.busId = busId;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public long getNextStopId() {
        return nextStopId;
    }

    public void setNextStopId(long nextStopId) {
        this.nextStopId = nextStopId;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated() {
        this.lastUpdated = LocalDateTime.now();
    }

    public List<Double> getSecondsTillArrival() {
        return secondsTillArrival;
    }

    public void setSecondsTillArrival(List<Double> secondsTillArrival) {
        this.secondsTillArrival = secondsTillArrival;
    }

    //Same bus vs same instance?
    @Override
    public boolean equals(Object bus) {
        //Check if same object
        if (this == bus) {
            return true;
        }

        //Verify object isn't null and that object is same class
        if (bus == null || getClass() != bus.getClass()) {
            return false;
        }

        long busId = ((Bus) bus).busId;

        return this.busId == busId;
    }

    @Override
    public String toString() {
        return ("Bus{" +
                "busId=" + busId +
                ", routeId=" + routeId +
                ", nextStopId=" + nextStopId +
                ", lastUpdated=" + lastUpdated +
                ", secondsTillArrival=" + secondsTillArrival +
                '}'
        );
    }
}