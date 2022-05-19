package ea.badge.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Timeslot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "start_time")
    private LocalTime startTime;
    @Column(name = "end_time")
    private LocalTime endTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
//    @JsonBackReference
    private Location location;

    @Enumerated(EnumType.STRING)
    private Days days;

    public Timeslot(Integer id, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
