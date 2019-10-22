package fa;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

public class Specification {
    /*
    Un parking applique le tarif suivant à ses usagers :
        la première heure est gratuite
        2 euros par heure entamée jusqu'a 4 h
        1,5 euros par demie heure entamée au-dela de 4h
     */

    @Test
    public void first_hour_is_free() {
        LocalDateTime arrival = LocalDateTime.now().minusMinutes(1);
        LocalDateTime departure = arrival.plusMinutes(1);

        Long toto = new ParkingTicket(arrival, departure).price();

        assertThat(toto).isEqualTo(0);
    }

    @Test
    public void second_hour_is_2_euros() {
        LocalDateTime arrival = LocalDateTime.now().minusMinutes(1);
        LocalDateTime departure = arrival.plusMinutes(61);

        Long toto = new ParkingTicket(arrival, departure).price();

        assertThat(toto).isEqualTo(200);
    }

    @Test
    public void second_hour_is_2_euros_() {
        LocalDateTime arrival = LocalDateTime.now().minusMinutes(1);
        LocalDateTime departure = arrival.plusMinutes(62);

        Long toto = new ParkingTicket(arrival, departure).price();

        assertThat(toto).isEqualTo(200);
    }


    @Test
    public void first_hour_is_free_included() {
        LocalDateTime arrival = LocalDateTime.now();
        LocalDateTime departure = arrival.plusMinutes(60);

        Long toto = new ParkingTicket(arrival, departure).price();

        assertThat(toto).isEqualTo(0);
    }


    @Test
    public void the_price_is_4_euros_for_a_stay_of_3_started_hours() {
        LocalDateTime arrival = LocalDateTime.now();
        LocalDateTime departure = arrival.plusMinutes(121);
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
            if (Duration.between(arrival, departure).toMinutes() >= 121) {
                return 400L;
            }
            if (Duration.between(arrival, departure).toMinutes() >= 61) {
                return 200L;
            }
            return 0L;
        }
    }
}
