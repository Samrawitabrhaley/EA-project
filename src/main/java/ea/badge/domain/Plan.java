package ea.badge.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name="Plan")
public class Plan {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PlanName", nullable = false)
    private String planName;

    @Column(name = "Description", nullable = true)
    private String planDescription;

    @OneToMany
    @JoinColumn(name = "plan_id")
    private List<Role> role;
}
