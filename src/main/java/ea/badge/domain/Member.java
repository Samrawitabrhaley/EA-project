package ea.badge.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    @OneToMany()
    @JoinTable(name = "Member_Role",
        joinColumns = { @JoinColumn(name = "Member_id") },
        inverseJoinColumns = { @JoinColumn(name = "Role_id") }
    )
    private Collection<Role> role = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private Collection<Membership> membership = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private Collection<Badge> badge = new ArrayList<>();
}
