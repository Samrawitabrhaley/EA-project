package ea.badge.service;

import ea.badge.domain.Timeslot;

import java.util.List;
import java.util.Optional;

public interface TimeSlotService {
    Timeslot addNewTimeSlot(Timeslot timeslot);

    Timeslot getTimeSlotById(Long id);

    List<Timeslot> getAllTimeSlots();

    void deleteTimeSlotById(long id);

    boolean existTimeSlotById(long id);
}
