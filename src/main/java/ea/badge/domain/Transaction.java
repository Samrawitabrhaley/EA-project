package ea.badge.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
//    @JsonBackReference
    private Badge badge;

    @ManyToOne
//    @JsonBackReference
    private Location location;

    private LocalDateTime datetime;

    private Boolean succeed;

    public Transaction(Long id, LocalDateTime datetime) {
        this.id = id;
        this.datetime = datetime;
    }

    public Transaction(Badge badge, Location location, Boolean succeed) {
        this.badge = badge;
        this.location = location;
        this.datetime = LocalDateTime.now();
        this.succeed = succeed;
    }
}
