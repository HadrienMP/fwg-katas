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
            "60,200", "120,400", "180,600"
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
            "211", "212", "213", "239"
    })
    public void the_price_is_7_euros_50_for_a_stay_of_4_started_hours_and_a_half(int minutes) {
        LocalDateTime arrival = LocalDateTime.now();
        LocalDateTime departure = arrival.plusMinutes(minutes);
        ParkingTicket parkingTicket = new ParkingTicket(arrival, departure);

        assertThat(parkingTicket.price()).isEqualTo(750);
    }

    @Test
    @Parameters({
            "241", "242", "243"
    })
    public void the_price_is_9_euros_for_a_stay_of_5_started_hours(int minutes) {
        LocalDateTime arrival = LocalDateTime.now();
        LocalDateTime departure = arrival.plusMinutes(minutes);
        ParkingTicket parkingTicket = new ParkingTicket(arrival, departure);

        assertThat(parkingTicket.price()).isEqualTo(900);
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
            if (timeInParking.toMinutes() > 180 + 2 * 30) return 600 + 2 * 150L;
            if (timeInParking.toMinutes() > 180 + 1 * 30) return 600 + 1 * 150L;
            long billableHours = startedHours(timeInParking);
            return billableHours * 200L;
        }

        private long startedHours(Duration between) {
            return between.toHours();
        }
    }
}
