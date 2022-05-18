package ea.badge.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private String description;

    private int capacity;

    @Column
    @Enumerated(EnumType.STRING)
    private LocationType locationType;

    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="location_id")
//    @JsonManagedReference
    private List<Plan> plans = new ArrayList<>();

    @OneToMany(mappedBy = "location",cascade = CascadeType.ALL)
//    @JsonManagedReference
    private List<Membership> memberships = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="location_Id")
//    @JsonManagedReference
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
