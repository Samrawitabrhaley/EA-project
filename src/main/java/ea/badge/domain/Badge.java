package ea.badge.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate activationDate;
    private LocalDate expirationDate;
    private Boolean active;

    @ManyToOne
    Member member;
}
