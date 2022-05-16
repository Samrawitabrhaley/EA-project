package ea.badge.repository;

import ea.badge.domain.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepository extends JpaRepository<Timeslot, Integer> {
}
