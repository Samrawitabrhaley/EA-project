package ea.badge.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @OneToOne(name= "role_Id")
    private Role role;

    @OneToMany(mappedBy = "member")
    private Membership membership;

    @OneToMany(mappedBy = "member")
    private Badge badge;
}
