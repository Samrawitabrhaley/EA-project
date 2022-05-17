package ea.badge.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Getter@Setter
public class Plan {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PlanName", nullable = false)
    private String planName;

    @Column(name = "Description", nullable = true)
    private String planDescription;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "Plan_Role",
            joinColumns = { @JoinColumn(name = "Plan_id") },
            inverseJoinColumns = { @JoinColumn(name = "Role_id") }
    )
    private List<Role> role;

    @OneToOne()
    @JoinColumn(name = "Rule_id")
    private Rule rule;

    public Plan(Long id, String planName, String planDescription) {
        this.id = id;
        this.planName = planName;
        this.planDescription = planDescription;
    }
}
