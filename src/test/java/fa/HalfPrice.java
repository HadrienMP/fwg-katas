package fa;

public class HalfPrice {

    private BasePrice basePrice = new BasePrice();

    long of(TimeInParking timeInParking) {
        return basePrice.of(timeInParking) / 2;
    }
}
