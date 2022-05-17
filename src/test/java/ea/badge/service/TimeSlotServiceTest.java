package ea.badge.service;

import ea.badge.domain.Member;
import ea.badge.domain.Rule;
import ea.badge.domain.Timeslot;
import ea.badge.repository.RuleRepository;
import ea.badge.repository.TimeSlotRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class TimeSlotServiceTest {
    List<Timeslot> timeslotList=new ArrayList<>();
    @Mock
    private TimeSlotRepository timeSlotRepository;

    @InjectMocks
    private TimeSlotServiceImpl timeSlotService;




    @Test
    void addNewTimeSlot() {
        Timeslot slot1=new Timeslot(1, LocalTime.of(1,45,30),LocalTime.of(2,45,30));
        Mockito.when(timeSlotRepository.save(slot1)).thenReturn(slot1);
        Timeslot actual=timeSlotService.addNewTimeSlot(slot1);
        assertThat(actual).isEqualTo(slot1);
    }

    @Test
    void getTimeSlotById() {
        int id = 2;
        Timeslot slot2=new Timeslot(2, LocalTime.of(1,45,30),LocalTime.of(2,45,30));
        Optional<Timeslot> slotOptional = Optional.of(slot2);
        Mockito.when(timeSlotRepository.findById(id))
                .thenReturn(slotOptional);
        Optional<Timeslot> actual = timeSlotService.getTimeSlotById(id);
        assertThat(actual.get().getId())
                .isEqualTo(id);
    }
}