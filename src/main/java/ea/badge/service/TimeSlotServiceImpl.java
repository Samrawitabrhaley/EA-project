package ea.badge.service;

import ea.badge.domain.Timeslot;
import ea.badge.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimeSlotServiceImpl implements TimeSlotService{

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Override
    public Timeslot addNewTimeSlot(Timeslot timeslot) {
        return timeSlotRepository.save(timeslot);
    }

    @Override
    public Optional<Timeslot> getTimeSlotById(int id) {
        return timeSlotRepository.findById(id);
    }
}
