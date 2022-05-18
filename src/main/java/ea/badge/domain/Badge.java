package ea.badge.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate activationDate;
    private LocalDate expirationDate;
    private Boolean active;

    @ManyToOne
//    @JsonBackReference
    private Member member;

    public Badge(LocalDate activationDate, LocalDate expirationDate, Boolean active, Member member) {
        this.activationDate = activationDate;
        this.expirationDate = expirationDate;
        this.active = active;
        this.member = member;
    }
}
