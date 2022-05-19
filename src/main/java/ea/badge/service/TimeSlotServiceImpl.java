package ea.badge.service;

import ea.badge.domain.Timeslot;
import ea.badge.exception.ResourceNotFoundException;
import ea.badge.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TimeSlotServiceImpl implements TimeSlotService {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Override
    public Timeslot addNewTimeSlot(Timeslot timeslot) {
        return timeSlotRepository.save(timeslot);
    }

    @Override
    public Timeslot getTimeSlotById(Integer id) {
        return timeSlotRepository.getById(id);
    }

    @Override
    public List<Timeslot> getAllTimeSlots() {
        return timeSlotRepository.findAll();
    }

    @Override
    public void deleteTimeSlotById(long id) {
        if (!timeSlotRepository.existsById((int) id)) {
            throw new ResourceNotFoundException();
        }
        timeSlotRepository.deleteById((int) id);
    }

    @Override
    public boolean existTimeSlotById(long id) {
        return timeSlotRepository.existsById((int) id);
    }
}
