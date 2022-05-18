package ea.badge.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Getter@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @OneToOne(cascade =CascadeType.PERSIST)
    @JoinColumn(name = "member_Id")
    private Member member;
}
