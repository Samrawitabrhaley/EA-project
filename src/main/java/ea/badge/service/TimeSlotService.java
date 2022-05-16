package ea.badge.service;

import ea.badge.domain.Timeslot;

import java.util.Optional;

public interface TimeSlotService {
    Timeslot addNewTimeSlot(Timeslot timeslot);

    Optional<Timeslot> getTimeSlotById(int id);
}
