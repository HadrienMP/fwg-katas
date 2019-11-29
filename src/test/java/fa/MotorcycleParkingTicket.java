package fa;

class MotorcycleParkingTicket {
    private final ParkingTicket parkingTicket;

    public MotorcycleParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    Long price() {
        return parkingTicket.price() / 2;
    }

}
