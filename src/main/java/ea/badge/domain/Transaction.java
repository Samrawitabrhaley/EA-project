package ea.badge.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Badge badge;

    @ManyToOne
    private Location location;

    private LocalDate datetime;

    private Boolean succeed;

    public Transaction(Integer id, LocalDate datetime) {
        this.id = id;
        this.datetime = datetime;
    }
}
