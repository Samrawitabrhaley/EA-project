package ea.badge.domain;

import lombok.Data;

import javax.persistence.*;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "Time_Slot")
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "start_time")
    private LocalTime startTime;
    @Column(name = "end_time")
    private LocalTime endTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;

    @Enumerated(EnumType.STRING)
    private Days days;
}
