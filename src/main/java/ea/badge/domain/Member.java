package ea.badge.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    @OneToOne
    @Column(name = "Role")
    private Role role;
    @OneToMany(mappedBy = "member")
    private List<Membership> membership = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Badge> badge = new ArrayList<>();
}
