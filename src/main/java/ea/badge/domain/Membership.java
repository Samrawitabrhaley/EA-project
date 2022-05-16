package ea.badge.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MembershipType membershipType;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "member_Id")
    private Member member;

    @OneToOne
    @JoinColumn(name="plan_Id")
    private Plan plan;

    @ManyToMany
    @JoinTable(name="Membership_Location",
            joinColumns = {@JoinColumn(name="membership_Id", referencedColumnName = "membershipId")},
            inverseJoinColumns = {@JoinColumn(name="location_Id", referencedColumnName = "locationId")}
    )
    private List<Location> locations;









}
