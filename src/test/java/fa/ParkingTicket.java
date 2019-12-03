package fa;

import java.time.LocalDateTime;

class ParkingTicket {
    private final LocalDateTime arrival;
    private final LocalDateTime departure;

    public ParkingTicket(LocalDateTime arrival, LocalDateTime departure) {
        this.arrival = arrival;
        this.departure = departure;
    }

    Long price() {
        TimeInParking timeInParking = timeInParking();
        return new BasePrice().of(timeInParking);
    }

    public TimeInParking timeInParking() {
        return TimeInParking.of(arrival, departure);
    }

}
