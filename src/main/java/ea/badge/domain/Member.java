package ea.badge.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
//    @JsonBackReference
    private Collection<Role> role = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("member")
    private Collection<Membership> membership = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private Collection<Badge> badge = new ArrayList<>();

    public Member(Long id, String firstName, String lastName, String emailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }



}
