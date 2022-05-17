package ea.badge.controller;

import ea.badge.domain.Timeslot;
import ea.badge.dto.TimeslotDto;
import ea.badge.service.TimeSlotService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/timeslots")
public class TimeSlotController {

    @Autowired
    private TimeSlotService timeSlotService;
    private ModelMapper mapper = new ModelMapper();

    @GetMapping(value = "/{id}")
    public TimeslotDto getTimeSlotById(@PathVariable int id) {
        return mapper.map(timeSlotService.getTimeSlotById(id).get(), TimeslotDto.class);
//        return timeSlotService.getTimeSlotById(id);
    }

    @PostMapping
    public TimeslotDto addNewTimeSlot(@RequestBody TimeslotDto timeslot) {
        return mapper.map(timeSlotService.addNewTimeSlot(mapper
                .map(timeslot, Timeslot.class)), TimeslotDto.class);
//        return timeSlotService.addNewTimeSlot(timeslot);
    }
}
