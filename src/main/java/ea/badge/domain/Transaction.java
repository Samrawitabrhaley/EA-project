package ea.badge.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Badge badge;

    @OneToOne
    private Location location;

    private LocalDateTime datetime;

    public Transaction(Long id, LocalDateTime datetime) {
        this.id = id;
        this.datetime = datetime;
    }
}
