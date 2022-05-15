package ea.badge.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Badge {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "activation_date")
    private LocalDate activationDate;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    private Boolean active;

    @ManyToOne
    Member member;
}
