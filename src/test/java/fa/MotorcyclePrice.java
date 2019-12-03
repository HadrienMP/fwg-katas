package fa;

public class MotorcyclePrice {

    private BasePrice basePrice = new BasePrice();

    long of(TimeInParking timeInParking) {
        return basePrice.of(timeInParking) / 2;
    }
}
