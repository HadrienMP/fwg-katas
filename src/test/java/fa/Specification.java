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
    public void less_than_an_hour_is_free() {
        LocalDateTime arrival = LocalDateTime.now().minusMinutes(1);
        LocalDateTime departure = arrival.plusMinutes(1);

        Long toto = new ParkingTicket(arrival, departure).price();

        assertThat(toto).isEqualTo(0);
    }

    @Test
    public void the_first_minute_of_the_second_hour_is_still_free() {
        LocalDateTime arrival = LocalDateTime.now();
        LocalDateTime departure = arrival.plusHours(1).plusSeconds(59);

        Long toto = new ParkingTicket(arrival, departure).price();

        assertThat(toto).isEqualTo(0);
    }

    @Test
    public void second_hour_is_2_euros() {
        LocalDateTime arrival = LocalDateTime.now().minusMinutes(1);
        LocalDateTime departure = arrival.plusHours(1).plusMinutes(1);

        Long toto = new ParkingTicket(arrival, departure).price();

        assertThat(toto).isEqualTo(200);
    }

    @Test
    public void second_hour_is_2_euros_() {
        LocalDateTime arrival = LocalDateTime.now().minusMinutes(1);
        LocalDateTime departure = arrival.plusHours(1).plusMinutes(2);

        Long toto = new ParkingTicket(arrival, departure).price();

        assertThat(toto).isEqualTo(200);
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

    private static class ParkingTicket {
        private final LocalDateTime arrival;
        private final LocalDateTime departure;

        private ParkingTicket(LocalDateTime arrival, LocalDateTime departure) {
            this.arrival = arrival;
            this.departure = departure;
        }

        private Long price() {
            if (Duration.between(arrival, departure).toMinutes() > 2 * 60) {
                return 400L;
            }
            if (Duration.between(arrival, departure).toMinutes() > 60) {
                return 200L;
            }
            return 0L;
        }
    }
}
