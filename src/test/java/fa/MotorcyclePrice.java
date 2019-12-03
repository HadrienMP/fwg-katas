package fa;

public class MotorcyclePrice {
    static long of(TimeInParking timeInParking) {
        return new BasePrice().of(timeInParking) / 2;
    }
}
