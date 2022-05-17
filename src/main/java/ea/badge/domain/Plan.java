package ea.badge.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Plan {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PlanName", nullable = false)
    private String planName;

    @Column(name = "Description", nullable = true)
    private String planDescription;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "Plan_Role",
            joinColumns = { @JoinColumn(name = "Plan_id") },
            inverseJoinColumns = { @JoinColumn(name = "Role_id") }
    )
    private List<Role> role;

    @OneToOne()
    @JoinColumn(name = "Rule_id")
    private Rule rule;

    public Plan(Integer id, String planName, String planDescription) {
        this.id = id;
        this.planName = planName;
        this.planDescription = planDescription;
    }
}
