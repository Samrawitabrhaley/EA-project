package ea.badge.service;

import ea.badge.domain.Member;
import ea.badge.domain.Plan;
import ea.badge.repository.MemberRepository;
import ea.badge.repository.PlanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PlanServiceTest {
    List<Plan> planList=new ArrayList<>();
    @Mock
    private PlanRepository planRepository;

    @InjectMocks
    private PlanServiceImpl planService;

    @BeforeEach
    public void setup() {

        Plan plan1=new Plan(1,"fulltime","Unlimited");
        Plan plan2=new Plan(2,"fulltime","limited");
        planList.add(plan1);
        planList.add(plan2);
    }

    @Test
    void addPlan() {
        Plan plan3=new Plan(3,"parttime","unlimited");
        Mockito.when(planRepository.save(plan3)).thenReturn(plan3);
        Plan actual=planService.addPlan(plan3);
        assertThat(actual).isEqualTo(plan3);


    }

    @Test
    void removePlan() {
        planService.removePlan(1);
        verify(planRepository, times(1)).deleteById(1);
    }

    @Test
    void findAll() {
        Mockito.when(planRepository.findAll()).thenReturn(planList);
        Collection<Plan> actual = planService.findAll();
        assertThat(actual).isEqualTo(planList);



    }

    @Test
    void getById() {
        Mockito.when(planRepository.getById(1)).thenReturn(planList.get(0));
        Integer id=1;
        Plan actual=planService.getById(id);
        assertThat(actual.getPlanName()).isEqualTo("fulltime");
    }
}