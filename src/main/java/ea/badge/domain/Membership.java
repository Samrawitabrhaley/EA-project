package ea.badge.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column
    @Enumerated(EnumType.STRING)
    private MembershipType membershipType;

    @ManyToOne
    @JoinColumn(name = "member_Id")
    private Member member;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "Membership_Plan",
            joinColumns = { @JoinColumn(name = "Membership_id") },
            inverseJoinColumns = { @JoinColumn(name = "Plan_id") }
    )
    private Collection<Plan> plan = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "location_Id")
    private Location location;

    public Membership(Long id, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
