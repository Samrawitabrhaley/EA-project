package ea.badge.dto;


import ea.badge.domain.LocationType;
import ea.badge.domain.Membership;
import ea.badge.domain.Plan;
import ea.badge.domain.Timeslot;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Component
@NoArgsConstructor
@Data
@Getter@Setter
public class LocationDto {
    private String name;

    private String description;

    private int capacity;

    private LocationType locationType;

}
