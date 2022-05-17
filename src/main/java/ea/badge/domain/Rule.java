package ea.badge.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter@Setter
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int perDurationDays;
    @Column(nullable = false)
    private int allowedLimit;

    public Rule(long id, int perDurationDays, int allowedLimit) {
        this.id = id;
        this.perDurationDays = perDurationDays;
        this.allowedLimit = allowedLimit;
    }
}
