package fa;

import java.time.Duration;

class BasePrice implements Price{
    private static final long FULL_HOUR_PRICE = 200L;
    private static final long HALF_HOUR_PRICE = 150L;
    private static final Duration FULL_HOUR_PRICE_TIME_LIMIT = Duration.ofHours(4);

    @Override
    public long of(TimeInParking timeInParking) {
        long billableHours = timeInParking.startedHoursUpTo(FULL_HOUR_PRICE_TIME_LIMIT);
        long billableHalfHours = timeInParking.halfHoursAfter(FULL_HOUR_PRICE_TIME_LIMIT);
        return billableHours * FULL_HOUR_PRICE + billableHalfHours * HALF_HOUR_PRICE;
    }
}
