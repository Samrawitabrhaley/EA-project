package ea.badge.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import ea.badge.domain.Plan;

@Entity
@NoArgsConstructor
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Lob
    private String description;

    private int capacity;

    @Column
    @Enumerated(EnumType.STRING)
    private LocationType locationType;

    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="location_id")
    private List<Plan> planList;

    @OneToMany(mappedBy = "location",cascade = CascadeType.ALL)
    private List<Membership>membershipList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="location_Id")
    private List<TimeSlot> timeSlotList;

    public void addMember(Membership membership){
        this.membershipList.add(membership);
    }
    public void addTimeSlot(TimeSlot timeSlot){
        this.timeSlotList.add(timeSlot);
    }
    public void addPlan(Plan plan){
        this.planList.add(plan);
    }
}
