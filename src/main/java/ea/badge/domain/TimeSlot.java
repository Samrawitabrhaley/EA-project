package ea.badge.domain;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "Time_Slots")
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "start_time")
    private LocalTime startTime;
    @Column(name = "end_time")
    private LocalTime endTime;

    @ManyToOne
    private Location location;

    @Enumerated(EnumType.STRING)
    private Days days;
}
