package ea.badge.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer id;

    @Column(name = "PlanName", nullable = false)
    private String planName;

    @Column(name = "Description", nullable = true)
    private String planDescription;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Plan_Role",
            joinColumns = { @JoinColumn(name = "Plan_id") },
            inverseJoinColumns = { @JoinColumn(name = "Role_id") }
    )
    @JsonIgnore
    private List<Role> role;

    @OneToOne()
    @JsonIgnore
    @JoinColumn(name = "Rule_id")
    private Rule rule;

    public Plan(Integer id, String planName, String planDescription) {
        this.id = id;
        this.planName = planName;
        this.planDescription = planDescription;
    }
}
