package fa;

class MotorcycleParkingTicket {
    private final ParkingTicket parkingTicket;

    public MotorcycleParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    Long price() {
        TimeInParking timeInParking = parkingTicket.timeInParking();
        return new MotorcyclePrice().of(timeInParking);
    }

}
