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
        TimeInParking timeInParking = timeInParking();
        Pricing pricing = vehicle.price();
        return pricing.of(timeInParking);
    }

    public TimeInParking timeInParking() {
        return TimeInParking.of(arrival, departure);
    }

}
