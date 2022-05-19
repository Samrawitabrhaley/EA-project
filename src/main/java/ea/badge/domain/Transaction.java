package ea.badge.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
//    @JsonBackReference
    private Badge badge;

    @ManyToOne
    @JsonIgnore
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
