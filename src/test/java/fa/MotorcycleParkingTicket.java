package fa;

import java.time.Duration;
import java.time.LocalDateTime;

class MotorcycleParkingTicket {
    private final LocalDateTime arrival;
    private final LocalDateTime departure;

    public MotorcycleParkingTicket(LocalDateTime arrival, LocalDateTime departure) {
        this.arrival = arrival;
        this.departure = departure;
    }

    Long price() {
        return new ParkingTicket(arrival, departure, false).price() / 2;
    }

}
