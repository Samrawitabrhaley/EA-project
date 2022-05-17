package ea.badge.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "Member_Role",
        joinColumns = { @JoinColumn(name = "Member_id") },
        inverseJoinColumns = { @JoinColumn(name = "Role_id") }
    )
    private Collection<Role> role = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private Collection<Membership> membership = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private Collection<Badge> badge = new ArrayList<>();

    public Member(Long id, String firstName, String lastName, String emailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }



}
