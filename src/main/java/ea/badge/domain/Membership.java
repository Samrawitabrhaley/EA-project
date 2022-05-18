package ea.badge.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
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
//    @JsonIgnoreProperties("membership")
//    @JsonBackReference
    private Member member;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "Membership_Plan",
            joinColumns = { @JoinColumn(name = "Membership_id") },
            inverseJoinColumns = { @JoinColumn(name = "Plan_id") }
    )
//    @JsonBackReference
    private Collection<Plan> plan = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "location_Id")
//    @JsonBackReference
    private Location location;

    public Membership(Long id, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
