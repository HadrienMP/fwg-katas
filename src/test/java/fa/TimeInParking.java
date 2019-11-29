package fa;

import java.time.Duration;
import java.time.LocalDateTime;

class TimeInParking {
    private final Duration timeInParking;

    private TimeInParking(Duration timeInParking) {
        this.timeInParking = timeInParking;
    }

    static TimeInParking of(LocalDateTime arrival, LocalDateTime departure) {
        return new TimeInParking(Duration.between(arrival, departure));
    }

    long startedHoursUpTo(Duration duration) {
        return Math.min(duration.toHours(), startedHours()) - 1;
    }

    private long startedHours() {
        return timeInParking.plusHours(1).toHours();
    }

    long halfHoursAfter(Duration duration) {
        return Math.max(0, startedHalfHours() - toHalfHours(duration));
    }

    private long startedHalfHours() {
        return toHalfHours(timeInParking.plusMinutes(30));
    }

    private long toHalfHours(Duration duration) {
        return duration.toMinutes() / 30;
    }
}
