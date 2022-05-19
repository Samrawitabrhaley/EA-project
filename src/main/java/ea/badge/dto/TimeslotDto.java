package ea.badge.dto;
import ea.badge.domain.Days;
import ea.badge.domain.Location;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalTime;


@Component
@NoArgsConstructor
@Data
@Getter@Setter
public class TimeslotDto {
    private LocalTime startTime;
    private LocalTime endTime;
//    private LocationDto location;
    private Days days;

}
