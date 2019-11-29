package fa;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MotorcycleSpecification {

    @Test
    @Parameters({
            "60"
    })
    public void the_price_is_1_euros_for_a_stay_of_2_started_hours(int minutes) {
        LocalDateTime arrival = LocalDateTime.now();
        LocalDateTime departure = arrival.plusMinutes(minutes);
        ParkingTicket parkingTicket = new ParkingTicket(arrival, departure, "Motorcycle");

        assertThat(parkingTicket.price()).isEqualTo(100);
    }


}
