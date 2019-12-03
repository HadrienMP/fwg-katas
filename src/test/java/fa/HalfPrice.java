package fa;

public class HalfPrice implements Price {

    private BasePrice basePrice = new BasePrice();

    @Override
    public long of(TimeInParking timeInParking) {
        return basePrice.of(timeInParking) / 2;
    }
}
