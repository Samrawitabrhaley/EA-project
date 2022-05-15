package ea.badge.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long membershipId;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "member_Id")
    private Member member;

    @OneToOne
    @JoinColumn(name="plan_Id")
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "location_Id")
    private Location location;









}
