package ea.badge.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    @JoinColumn(name = "member_Id")
//    @JsonBackReference
    private Member member;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JsonIgnore
    @JoinTable(name = "Membership_Plan",
            joinColumns = { @JoinColumn(name = "Membership_id") },
            inverseJoinColumns = { @JoinColumn(name = "Plan_id") }
    )
//    @JsonBackReference
    private Collection<Plan> plan = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "location_Id")
//    @JsonBackReference
    private Location location;

    public Membership(Long id, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
