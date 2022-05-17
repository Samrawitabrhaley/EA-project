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

    private List<Plan> plans = new ArrayList<>();

    private List<Membership> memberships = new ArrayList<>();

    private List<Timeslot> timeslots = new ArrayList<>();

    public void addMember(Membership membership){
        this.memberships.add(membership);
    }
    public void addTimeSlot(Timeslot timeSlot){
        this.timeslots.add(timeSlot);
    }
    public void addPlan(Plan plan){
        this.plans.add(plan);
    }

}
