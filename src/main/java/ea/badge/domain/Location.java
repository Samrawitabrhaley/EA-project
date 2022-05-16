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

    @OneToMany
    @JoinColumn(name="location_id")
    private List<Plan> planList;

    @OneToMany(mappedBy = "location")
    private List<Membership>membershipList;

    @OneToMany
    @JoinColumn(name="location_id")
    private List<TimeSlot> timeSlotList;

}
