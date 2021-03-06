package ea.badge.controller;

import ea.badge.domain.Member;
import ea.badge.domain.Timeslot;
import ea.badge.dto.MemberDto;
import ea.badge.dto.TimeslotDto;
import ea.badge.service.TimeSlotService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/timeslots")
public class TimeSlotController {

    @Autowired
    private TimeSlotService timeSlotService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/{id}")
    public TimeslotDto getTimeSlotById(@PathVariable(name = "id") Long id) {
        return mapper.map(timeSlotService.getTimeSlotById(id), TimeslotDto.class);
    }

    @PostMapping
    public TimeslotDto addNewTimeSlot(@RequestBody TimeslotDto timeslot) {
        return mapper.map(timeSlotService.addNewTimeSlot(mapper
                .map(timeslot, Timeslot.class)), TimeslotDto.class);
    }

    @GetMapping
    public List<TimeslotDto> getAllTimeSlots() {
        return timeSlotService.getAllTimeSlots().stream()
                .map(timeslot -> mapper.map(timeslot, TimeslotDto.class)).collect(Collectors.toList());
    }
    @PutMapping
    public TimeslotDto updateTimeslot(@Valid @RequestBody Timeslot timeslot){
        return mapper.map(timeSlotService.addNewTimeSlot(timeslot),TimeslotDto.class);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TimeslotDto> deleteTimeSlotById(@PathVariable long id) {
        if(timeSlotService.existTimeSlotById(id)) {
            timeSlotService.deleteTimeSlotById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    
}
