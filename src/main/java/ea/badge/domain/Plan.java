package ea.badge.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter@Setter
@AllArgsConstructor
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
    private List<Role> role = new ArrayList<>();

    @OneToOne()
    @JsonIgnore
    @JoinColumn(name = "Rule_id")
    private Rule rule;

    private boolean active = true;


    public Plan(Integer id, String planName, String planDescription, boolean active) {
        this.id = id;
        this.planName = planName;
        this.planDescription =planDescription;
        this.active = active;
    }
}
