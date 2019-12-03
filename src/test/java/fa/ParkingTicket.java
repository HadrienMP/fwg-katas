package fa;

import java.time.LocalDateTime;

class ParkingTicket {
    private final LocalDateTime arrival;
    private final LocalDateTime departure;
    private Vehicle vehicle;

    public ParkingTicket(LocalDateTime arrival, LocalDateTime departure, Vehicle vehicle) {
        this.arrival = arrival;
        this.departure = departure;
        this.vehicle = vehicle;
    }

    Long price() {
        if (vehicle == Vehicle.MOTORCYCLE)
            return new HalfPrice().of(timeInParking());
        TimeInParking timeInParking = timeInParking();
        return new BasePrice().of(timeInParking);
    }

    public TimeInParking timeInParking() {
        return TimeInParking.of(arrival, departure);
    }

}
