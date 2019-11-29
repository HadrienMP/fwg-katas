package fa;

import java.time.Duration;
import java.time.LocalDateTime;

class ParkingTicket {
    private static final long FULL_HOUR_PRICE = 200L;
    private static final long HALF_HOUR_PRICE = 150L;
    private static final Duration FULL_HOUR_PRICE_TIME_LIMIT = Duration.ofHours(4);
    private final LocalDateTime arrival;
    private final LocalDateTime departure;
    private String motorcycle;

    ParkingTicket(LocalDateTime arrival, LocalDateTime departure) {
        this.arrival = arrival;
        this.departure = departure;
    }

    public ParkingTicket(LocalDateTime arrival, LocalDateTime departure, String motorcycle) {
        this.arrival = arrival;
        this.departure = departure;
        this.motorcycle = motorcycle;
    }

    Long price() {
        if (motorcycle != null) return new ParkingTicket(arrival, departure).price() / 2;

        TimeInParking timeInParking = timeInParking();

        long billableHours = timeInParking.startedHoursUpTo(FULL_HOUR_PRICE_TIME_LIMIT);
        long billableHalfHours = timeInParking.halfHoursAfter(FULL_HOUR_PRICE_TIME_LIMIT);
        return billableHours * FULL_HOUR_PRICE + billableHalfHours * HALF_HOUR_PRICE;
    }

    private TimeInParking timeInParking() {
        return TimeInParking.of(arrival, departure);
    }

}
