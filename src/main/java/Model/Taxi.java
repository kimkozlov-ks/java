package Model;

import lombok.Builder;
import lombok.Data;

import java.time.DayOfWeek;

@Data
@Builder
public class Taxi {
    private String car;
    private String carNumber;
    private String driverName;
    private DayOfWeek restDay;
}
