package ea.badge.service;

import ea.badge.repository.RuleRepository;
import org.junit.Before;
import ea.badge.domain.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
public class RuleServiceImplTest {
    @TestConfiguration
    static class RuleServiceImplTestContextConfiguration {
        @Bean
        public RuleService ruleService() {
            return new RuleServiceImpl();
        }
    }
    @Autowired
    private RuleService ruleService;
    @MockBean
    private RuleRepository ruleRepository;

    @Before
    public void setup(){
        long ruleNumber = 123L;
        Rule rule = new  Rule(ruleNumber,7,21);
        Optional<Rule> ruleOptional = Optional.of(rule);
        Mockito.when(ruleRepository.findById(ruleNumber))
                .thenReturn(ruleOptional);
    }
    @Test
    public void whenValidRuleNumberThenRuleShouldBeFound() {
        Long ruleNumber = 123L;
        Optional<Rule> found = ruleService.findById(ruleNumber);
        assertThat(found.get().getId())
                .isEqualTo(ruleNumber);
    }
    @Test
    public void whenValidNumberDeletedThenShouldSuccess(){
        Long ruleNumber = 123L;
        ruleService.deleteById(ruleNumber);
    }
}