package ea.badge.controller;

import ea.badge.domain.Timeslot;
import ea.badge.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = {"timeSlots"})
public class TimeSlotController {

    @Autowired
    private TimeSlotService timeSlotService;

    @GetMapping(value = "/{id}")
    public Optional<Timeslot> getTimeSlotById(@PathVariable int id) {
        return timeSlotService.getTimeSlotById(id);
    }

    @PostMapping
    public Timeslot addNewTimeSlot(Timeslot timeslot) {
        return timeSlotService.addNewTimeSlot(timeslot);
    }
}
