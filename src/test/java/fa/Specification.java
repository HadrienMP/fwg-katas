package fa;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class Specification {

    /*
    Un parking applique le tarif suivant à ses usagers :
        la première heure est gratuite
        2 euros par heure entamée jusqu'a 4 h
        1,5 euros par demie heure entamée au-dela de 4h
     */
    @Test
    @Parameters({
            "60,0", "120,200", "180,400"
    })
    public void the_first_minute_of_the_second_hour_is_still_free(int minutes, int price) {
        LocalDateTime arrival = LocalDateTime.now();
        LocalDateTime departure = arrival.plusMinutes(minutes).plusSeconds(59);

        Long toto = new ParkingTicket(arrival, departure).price();

        assertThat(toto).isEqualTo(price);
    }

    @Test
    @Parameters({
            "1", "2", "59"
    })
    public void free_for_a_stay_of_1_started_hours(int minutes) {
        LocalDateTime arrival = LocalDateTime.now();
        LocalDateTime departure = arrival.plusMinutes(minutes);
        ParkingTicket parkingTicket = new ParkingTicket(arrival, departure);

        assertThat(parkingTicket.price()).isEqualTo(0);
    }

    @Test
    @Parameters({
            "61", "62", "119"
    })
    public void the_price_is_2_euros_for_a_stay_of_2_started_hours(int minutes) {
        LocalDateTime arrival = LocalDateTime.now();
        LocalDateTime departure = arrival.plusMinutes(minutes);
        ParkingTicket parkingTicket = new ParkingTicket(arrival, departure);

        assertThat(parkingTicket.price()).isEqualTo(200);
    }

    @Test
    @Parameters({
            "121", "122", "179"
    })
    public void the_price_is_4_euros_for_a_stay_of_3_started_hours(int minutes) {
        LocalDateTime arrival = LocalDateTime.now();
        LocalDateTime departure = arrival.plusMinutes(minutes);
        ParkingTicket parkingTicket = new ParkingTicket(arrival, departure);

        assertThat(parkingTicket.price()).isEqualTo(400);
    }

    @Test
    @Parameters({
            "181", "182", "209"
    })
    public void the_price_is_6_euros_for_a_stay_of_4_started_hours(int minutes) {
        LocalDateTime arrival = LocalDateTime.now();
        LocalDateTime departure = arrival.plusMinutes(minutes);
        ParkingTicket parkingTicket = new ParkingTicket(arrival, departure);

        assertThat(parkingTicket.price()).isEqualTo(600);
    }

    @Test
    @Parameters({
            "211", "212", "213"
    })
    public void the_price_is_7_euros_50_for_a_stay_of_4h30_started_hours(int minutes) {
        LocalDateTime arrival = LocalDateTime.now();
        LocalDateTime departure = arrival.plusMinutes(minutes);
        ParkingTicket parkingTicket = new ParkingTicket(arrival, departure);

        assertThat(parkingTicket.price()).isEqualTo(750);
    }

    private static class ParkingTicket {
        private final LocalDateTime arrival;
        private final LocalDateTime departure;

        private ParkingTicket(LocalDateTime arrival, LocalDateTime departure) {
            this.arrival = arrival;
            this.departure = departure;
        }

        private Long price() {
            Duration timeInParking = Duration.between(arrival, departure);
            if (timeInParking.toMinutes() > 210) return 750l;
            long billableHours = startedHours(timeInParking) - 1;
            return billableHours * 200L;
        }

        private long startedHours(Duration between) {
            return between.toMinutes() % 60 == 0 ? between.toHours(): between.toHours() + 1;
        }
    }
}
