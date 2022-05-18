package ea.badge.service;

import ea.badge.domain.Member;
import ea.badge.domain.Role;
import ea.badge.domain.Rule;
import ea.badge.repository.RoleRepository;
import ea.badge.repository.RuleRepository;
import org.assertj.core.api.AssertionsForClassTypes;
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
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RuleServiceTest {
    List<Rule> rulelist=new ArrayList<>();
    @Mock
    private RuleRepository ruleRepository;

    @InjectMocks
    private RuleServiceImpl ruleService;


    @BeforeEach
    public void setup() {

        Rule rule1=new Rule(1L,7,3);
        Rule rule2=new Rule(2L,3,1);
        rulelist.add(rule1);
        rulelist.add(rule2);


    }




    @Test
    void save() {
        Rule rule3=new Rule(3L,7,1);
        Mockito.when(ruleRepository.save(rule3)).thenReturn(rule3);
        Rule actual=ruleService.save(rule3);
        assertThat(actual).isEqualTo(rule3);
    }

    @Test
    void findAll() {
        Mockito.when(ruleRepository.findAll()).thenReturn(rulelist);
        Collection<Rule> actual = ruleService.findAll();
        assertThat(actual).isEqualTo(rulelist);
    }

      @Test
     void findById() {
          Long id = 3L;
          Rule rule4=new Rule(3L,7,1);
          Optional<Rule> ruleOptional = Optional.of(rule4);
          Mockito.when(ruleRepository.findById(id))
                  .thenReturn(ruleOptional);
          Rule actual = ruleService.findById(id);
          assertThat(actual.getId())
                  .isEqualTo(id);

      }

    @Test
    void deleteById() {
        Mockito.when(ruleRepository.existsById(1L)).thenReturn(true);
        ruleService.deleteById(1L);
        verify(ruleRepository, times(1)).deleteById(1L);
    }

//    @Test
//    void update() {
//        Rule rule4=new Rule(4L,3,4);
//        Optional<Rule> rule4opt = Optional.of(rule4);
//        Mockito.when(ruleRepository.save(rule4)).thenReturn(rule4);
//        Rule actual=ruleService.update(rule4,rule4.getId());
////        Rule actual=ruleService.update(rule4,rule4.getId());
//        assertThat(actual).isEqualTo(rule4);
//        verify(ruleRepository, times(1)).save(rule4);
//        when(ruleRepository)
//    }

    @Test
    void existsById() {
        Mockito.when(ruleRepository.existsById(1L)).thenReturn(true);
        Long id=1L;
        boolean actual=ruleService.existsById(id);
        assertThat(actual).isTrue();

    }
}